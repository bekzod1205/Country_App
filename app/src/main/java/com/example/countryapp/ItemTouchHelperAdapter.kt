package com.example.countryapp

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition:Int, toPosition:Int)

    fun onItemDismiss(position:Int)
}