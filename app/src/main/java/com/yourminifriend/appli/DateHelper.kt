package com.yourminifriend.appli

import java.text.SimpleDateFormat
import java.util.Date

fun today(): String = SimpleDateFormat.getDateInstance().format(Date())
