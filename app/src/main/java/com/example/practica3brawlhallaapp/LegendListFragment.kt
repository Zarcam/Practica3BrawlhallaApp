package com.example.practica3brawlhallaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LegendListFragment : Fragment() {
    private lateinit var v: View
    private val legendViewModel: LegendViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)
        val fm = parentFragmentManager

        val recyclerView = v.findViewById<RecyclerView>(R.id.recyclerview)
        var adaptador = LegendRecycleViewAdapter(this.legendViewModel.legends)

        //Al hacer click en uno de los botones de detalles se ejecuta este bloque
        adaptador.click = {position, legend -> run{
            this.legendViewModel.selected = legend

            /*Si la orientacion es vertical se sustituye este fragmento por el fragmento de detalles,
            y este fragmento pasa a la pila.

            Si la orientacion es horizontal el layout de este fragmento tendrá un fragmentContainerView
            en el cual mostraremos el fragmento de detalles*/
            if(!resources.getBoolean(R.bool.land)) {
                fm.commit {
                    replace(R.id.fragmentContainerView, LegendDetailFragment.newInstance())
                    addToBackStack("replacement")
                }
            }else{
                val contenedor = v.findViewById<FragmentContainerView>(R.id.detailFragmentContainer)
                val fragmentManager = childFragmentManager
                val fragment = fragmentManager.findFragmentById(contenedor?.id ?: -1)

                if(fragment != null && fragment is LegendDetailFragment){
                    (fragment as LegendDetailFragment).update()
                }
            }
        }}

        //Al hacer click en el boton de añadir personajes pasaremos al fragmento AddLegendFragment
        val addLegend = v.findViewById<FloatingActionButton>(R.id.addLegendButton)
        addLegend.setOnClickListener{
            fm.commit {
                replace(R.id.fragmentContainerView, AddLegendFragment.newInstance())
                addToBackStack("replacement")
            }
        }

        //Establecemos el tipo de layout y el adaptador del recyclerView
        val layoutManager = GridLayoutManager(this.context, 1)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adaptador
        return v
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LegendListFragment().apply {

            }
    }
}