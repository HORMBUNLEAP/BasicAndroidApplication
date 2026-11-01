package com.leap.basicApp.feature.profile

import com.leap.basicApp.model.UserModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.milliseconds

class UserRepository {
    private val userList = listOf(
        UserModel(id = 1, name = "John Doe", email = "william.henry.harrison@example-pet-store.com", age = 30),
        UserModel(id = 2, name = "Jane Smith", email = "james.wilson@example-pet-store.com", age = 25),
        UserModel(id = 3, name = "Bob Johnson", email = "john.mclean@examplepetstore.com", age = 35),
        UserModel(id = 4, name = "Alice Brown", email = "james.wilson@example-pet-store.com", age = 28),
        UserModel(id = 5, name = "Charlie Davis", email = "john.mclean@examplepetstore.com", age = 32)
    )

    /// filter user by id
    suspend fun getUserById(id: Int): Flow<UserModel?>{
        return flow {
            val user = userList.filter { it.id == id }
            delay(1000.milliseconds)
            if( user.isNotEmpty()){
                emit(user[0])
            }else{
                emit(null)
            }
        }
    }
}