package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CrudActivity : AppCompatActivity() {
    private lateinit var edName: EditText
    private lateinit var edEmail: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button
    private lateinit var btnUpdate: Button

    private lateinit var sqliteHelper: SQLiteHelper
    private lateinit var recyclerView: RecyclerView
    private var adapter: StudentAdapter? = null
    private var std:StudentModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        initView()
        initRecyclerView() // Llama a esta función para inicializar recyclerView
        sqliteHelper = SQLiteHelper(this)
        btnAdd.setOnClickListener { addStudent() }
        btnView.setOnClickListener { getStudents() }
        btnUpdate.setOnClickListener{ updateStudent()}

        adapter?.setOnClickItem { Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        edName.setText(it.name)
        edEmail.setText(it.email)
         std = it

        }
        adapter?.setOnClickDeleteItem {
    deleteStudent(it.id)
        }
    }

    private fun getStudents() {
        val stdList = sqliteHelper.getAllStudent()
        Log.e("pppp", "${stdList.size}")

        adapter?.addItems(stdList)
    }



    private fun addStudent() {
        val name = edName.text.toString()
        val email = edEmail.text.toString()

        if (name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Por favor completar el campo", Toast.LENGTH_SHORT).show()
        } else {
            val id = StudentModel.getAutoId()
            val std = StudentModel(id, name, email)
            val status = sqliteHelper.insertStudent(std)
            if (status > -1) {
                Toast.makeText(this, "Arma Agregada...", Toast.LENGTH_SHORT).show()
                clearEditText()
                getStudents()
            } else {
                Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteStudent(id: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("¿Estás seguro de eliminar el arma?")
        builder.setCancelable(true)
        builder.setPositiveButton("Sí") { dialog, _ ->
            sqliteHelper.deleteStudentById(id)
            getStudents()
            dialog.dismiss()
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
    }


    private fun updateStudent() {
        val name = edName.text.toString()
        val email = edEmail.text.toString()

        if (name == std?.name && email == std?.email) {
            Toast.makeText(this, "No se pudo cambiar", Toast.LENGTH_SHORT).show()
            return
        }

        if (std == null) {
            Toast.makeText(this, "No se ha seleccionado ningún Arma para actualizar", Toast.LENGTH_SHORT).show()
            return
        }

        val updatedStudent = StudentModel(id = std!!.id, name = name, email = email)
        val status = sqliteHelper.updateStudent(updatedStudent)

        if (status > -1) {
            Toast.makeText(this, "Arma actualizado con éxito", Toast.LENGTH_SHORT).show()
            clearEditText()
            getStudents()
        } else {
            Toast.makeText(this, "No se pudo actualizar el estudiante", Toast.LENGTH_SHORT).show()
        }
    }


    private fun clearEditText() {
        edName.setText("")
        edEmail.setText("")
        edEmail.requestFocus()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView) // Inicializa recyclerView aquí
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView() {
        edName = findViewById(R.id.edName)
        edEmail = findViewById(R.id.edEmail)
        btnAdd = findViewById(R.id.btnAdd)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnView = findViewById(R.id.btnView)
    }
}
