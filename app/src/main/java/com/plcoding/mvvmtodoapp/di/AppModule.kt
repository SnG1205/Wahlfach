package com.plcoding.mvvmtodoapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.plcoding.mvvmtodoapp.data.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(db: TodoDatabase): LoginRepository {
        return LoginRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideMessageRepository(db: TodoDatabase): MessageRepository {
        return MessageRepositoryImpl(db.dao)
    }

}