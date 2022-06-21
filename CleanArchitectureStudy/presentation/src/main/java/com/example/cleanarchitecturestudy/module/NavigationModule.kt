package com.example.cleanarchitecturestudy.module

import com.example.cleanarchitecturestudy.coordinator.Coordinator
import com.example.core.base.navi.Navigation
import com.example.core.base.navi.NavigationInterface
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val navigationModule: Module = module {
    singleOf(::Navigation)
    single<NavigationInterface> { Coordinator() }
//    singleOf(::Coordinator) bind NavigationInterface::class
}
