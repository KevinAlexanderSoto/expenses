package com.kalex.expenses.di

import android.content.Context
import androidx.room.Room
import com.kalex.expenses.data.db.ExpensesDataBase
import com.kalex.expenses.data.db.dao.ObligationDao
import org.koin.dsl.module

/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/

val dataBaseModule = module {
    single { expensesDataBase(get()) }
    single { provideObligationDao(get()) }
}

fun expensesDataBase(context: Context): ExpensesDataBase =
    Room.databaseBuilder(context, ExpensesDataBase::class.java, "expensesDBName").build()

fun provideObligationDao(database: ExpensesDataBase): ObligationDao = database.obligationDao
