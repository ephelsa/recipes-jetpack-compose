package com.github.ephelsa.yapecodechallenge.shared.data.model

interface DomainMapper<Domain> {
    fun asDomainModel(): Domain
}
