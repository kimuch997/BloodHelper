package com.example.bloodhelper.models

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.bloodhelper.data.AuthRepository
import com.example.bloodhelper.navigation.ROUTE_LOGIN_PAGE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DonorRepository(var navController: NavHostController, var context: Context) {
    var authRepository: AuthRepository
    var progress: ProgressDialog
    var donors:ArrayList<Donor>
    init {
        authRepository =AuthRepository(navController, context)
        if (!authRepository.isloggedIn()){
            navController.navigate(ROUTE_LOGIN_PAGE)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")

        donors = mutableListOf<Donor>() as ArrayList<Donor>
}
    fun signUpDonor(donorname:String, donoremail:String, donorbloodtype:String,donorphonenumber:String){
        var  id = System.currentTimeMillis().toString()
        var donorData = Donor(donorname,donoremail,donorbloodtype,donorphonenumber, id)
        var donorRef = FirebaseDatabase.getInstance().getReference()
            .child("Donors/$id")
        progress.show()
        donorRef.setValue(donorData).addOnCompleteListener {
            progress.dismiss()

            if (it.isSuccessful){
                Toast.makeText(context, "Donor saved successfully", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun viewDonor():ArrayList<Donor>{
        var ref = FirebaseDatabase.getInstance().getReference().child("Donors")
        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
                donors.clear()
                for(snap in snapshot.children){
                    var product = snap.getValue(Donor::class.java)
                    donors.add(product!!)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                progress.dismiss()
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return donors
    }
}