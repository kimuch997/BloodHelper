package com.example.bloodhelper.data

//import android.app.ProgressDialog
//import android.content.Context
//import android.widget.Toast
//import androidx.navigation.NavHostController
//import com.example.bloodhelper.models.Receivers
//import com.example.bloodhelper.navigation.ROUTE_HOME
//import com.example.bloodhelper.navigation.ROUTE_LOGIN_PAGE
//import com.example.bloodhelper.navigation.ROUTE_SIGNUP_PAGE
//
//class AuthRepository(var navController: NavHostController, var context: Context) {
//    var mAuth:IN FirebaseAuth
//    val progress: ProgressDialog
//    init {
//        mAuth = FirebaseAuth.getInstance()
//        progress = ProgressDialog(context)
//        progress.setTitle("Loading")
//        progress.setTitle("Please wait...")
//    }
//
//
//    fun signup(name:String, email:String, password:String){
//        progress.show()
//        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
//            progress.dismiss()
//            if (it.isSuccessful){
//                var userData = Receivers(name,email,password,mAuth.currentUser!!.uid)
//                var regRef = FirebaseDatabase.getInstance() .getReference()
//                    .child("Users/"+mAuth.currentUser!!.uid)
//                regRef.setValue(userData).addOnCompleteListener {
//                    if (it.isSuccessful){
//                        Toast.makeText(context,"Signup successful", Toast.LENGTH_SHORT).show()
//                        navController.navigate(ROUTE_HOME)
//                    }
//                    else{
//                        navController.navigate(ROUTE_LOGIN_PAGE)
//                    }
//                }
//            }else{
//                navController.navigate(ROUTE_SIGNUP_PAGE)
//            }
//        }
//
//    }
//
//
//    fun login(email: String, password: String) {
//        progress.show()
//        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
//            progress.dismiss()
//            if(it.isSuccessful){
//                Toast.makeText(context,"Login successful", Toast.LENGTH_SHORT).show()
//                navController.navigate(ROUTE_HOME)
//            }
//            else{
//                navController.navigate(ROUTE_LOGIN_PAGE)
//            }
//        }
//    }
//
//    fun logout() {
//        mAuth.signOut()
//        navController.navigate(ROUTE_LOGIN_PAGE)
//    }
//    fun isloggedIn():Boolean = mAuth.currentUser != null
//
//
//}