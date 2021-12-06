package com.zkathi.data.domain

interface Mapper<Tin, Tout> {
    fun map(input: Tin): Tout
}