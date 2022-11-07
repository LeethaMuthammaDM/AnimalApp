package com.happiestminds.animalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class AnimalFragment : Fragment() {

    private var columnCount = 1
    private var animalType=1
    val domesticAnimalList= mutableListOf<Animal>()
    val wildAnimalList= mutableListOf<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
            animalType=it.getInt(ARG_ANIMAL_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        populateData()

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                adapter=when(animalType){
                    1->AnimalAdapter(domesticAnimalList)
                    else->AnimalAdapter(wildAnimalList)
                }

            }
        }
        return view
    }

    private fun populateData() {
        domesticAnimalList.add(Animal("Parrot"))
        domesticAnimalList.add(Animal("Cat"))
        domesticAnimalList.add(Animal("Cow"))
        domesticAnimalList.add(Animal("Rabbit"))
        wildAnimalList.add(Animal("Lion"))
        wildAnimalList.add(Animal("Deer"))
        wildAnimalList.add(Animal("Rhinoceros"))
        wildAnimalList.add(Animal("Zebra"))


    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"
        const val ARG_ANIMAL_TYPE="animal_type"


        @JvmStatic
        fun newInstance(columnCount: Int,animalType:Int) =
            AnimalFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)

                    putInt(ARG_ANIMAL_TYPE,animalType)
                }
            }
    }
}