package com.example.practica3brawlhallaapp

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels

class AddLegendFragment : Fragment() {
    private lateinit var v: View
    private val legendViewModel: LegendViewModel by activityViewModels()
    //Imagen que se mostrará y asignará por defecto si no se selecciona otra
    private val DEFAULT_IMAGE_URI = Uri.parse("android.resource://com.example.practica3brawlhallaapp/drawable/randombrawl")
    //Imagen seleccionada desde la galeria que se asignará al nuevo personaje
    private var newLegendImageUri: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_add_legend, container, false)
        val fm = parentFragmentManager

        //Registramos un activity result para seleccionar fotos desde la galeria
        val selectImage = registerForActivityResult(ActivityResultContracts.GetContent()){
            if(it != null) {
                newLegendImageUri = it!!
                v.findViewById<ImageView>(R.id.newLegendImage).setImageURI(it)
            }
        }

        //Cancela la creación y vuelve al fragmento anterior al hacer click en el boton cancelar
        v.findViewById<Button>(R.id.newLegendCancel).setOnClickListener{
            fm.popBackStack()
        }

        //LLama al activityResult para seleccionar una imagen al hacer click en el boton de buscar imagen
        v.findViewById<Button>(R.id.newLegendSearchImage).setOnClickListener{
            selectImage.launch("image/*")
        }

        //Valida los campos del formulario y si es correcto añade el nuevo personaje a la lista
        //del viewModel y vuelve al fragmento anterior
        v.findViewById<Button>(R.id.newLegendConfirm).setOnClickListener{
            val newLegend: Legend? = validateForm()
            if(newLegend != null){
                legendViewModel.add(newLegend!!)
                fm.popBackStack()
            }
        }

        return v
    }

    /**
     * Valida los campos del formulario para crear un nuevo personaje. En caso de que alguno
     * sea incorrecto se mostrará en la interfaz como un mensaje de error
     *
     * @return El objeto Legend del nuevo personaje o null si algun campo era incorrecto
     */
    private fun validateForm(): Legend?{
        val newLegendName = v.findViewById<TextView>(R.id.newLegendName)

        val newLegendWeapon1 = v.findViewById<TextView>(R.id.newLegendWeapon1)
        val newLegendWeapon2 = v.findViewById<TextView>(R.id.newLegendWeapon2)

        val newLegendDmg = v.findViewById<TextView>(R.id.newLegendDamage)
        val newLegendDef = v.findViewById<TextView>(R.id.newLegendDefense)
        val newLegendDex = v.findViewById<TextView>(R.id.newLegendDexterity)
        val newLegendSpe = v.findViewById<TextView>(R.id.newLegendSpeed)
        val stats = arrayOf(newLegendDmg, newLegendDef, newLegendDex, newLegendSpe)

        val newLegendDesc = v.findViewById<TextView>(R.id.newLegendDescription)

        //Comprueba que el nombre no este en blanco
        if(newLegendName.text.isBlank()){
            newLegendName.error = "Legend Name Required"
            return null
        }

        //Comprueba que el arma1 no este en blanco
        if(newLegendWeapon1.text.isEmpty()){
            newLegendWeapon1.error = "Weapon required"
            return null
        }

        //Comprueba que el arma2 no este en blanco
        if(newLegendWeapon1.text.isEmpty()){
            newLegendWeapon2.error = "Weapon required"
            return null
        }

        //Comprueba que las cuatro estadisticas no esten en blanco y que esten entre 1 y 10
        stats.forEach{
            if(it.text.isEmpty() || it.text.toString().toInt() < 1 || it.text.toString().toInt() > 10){
                it.error = "Introduce a value between [1-10]"
                return null
            }
        }

        return Legend(newLegendName.text.toString(), arrayOf(newLegendWeapon1.text.toString(), newLegendWeapon2.text.toString()),
            newLegendDmg.text.toString().toInt(), newLegendDef.text.toString().toInt(), newLegendDex.text.toString().toInt(), newLegendSpe.text.toString().toInt(),
            newLegendDesc.text.toString(), if (newLegendImageUri != null) newLegendImageUri!! else DEFAULT_IMAGE_URI)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddLegendFragment().apply {

            }
    }
}