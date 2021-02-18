package com.example.recyclerteste

import androidx.lifecycle.ViewModel
import com.example.desafiomuxi.Fruits
import org.junit.Before
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class FruitsTest {

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testeValidoDeRetornoTrue() {
        var frutas = Fruits("Apple","image", 10.00)
        assertTrue(frutas.equals(Fruits("Apple","image", 10.00)))
    }

    @Test
    fun testeValidoDeRetornoFalse() {
        var frutas = Fruits("Apple","image", 10.00)
        assertFalse(frutas.equals(Fruits("Banana","image", 10.00)))
    }

}