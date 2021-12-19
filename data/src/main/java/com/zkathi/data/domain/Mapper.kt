package com.zkathi.data.domain

interface Mapper<Tin, Tout> {
    fun to(input: Tin): Tout
    fun from(output: Tout): Tin
}