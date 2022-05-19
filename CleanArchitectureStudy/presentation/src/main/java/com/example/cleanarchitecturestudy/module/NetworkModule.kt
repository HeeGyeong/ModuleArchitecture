package com.example.cleanarchitecturestudy.module

import com.example.core.base.util.NetworkManager
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule: Module = module {
    singleOf(::NetworkManager)
}
