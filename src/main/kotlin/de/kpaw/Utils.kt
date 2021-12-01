package de.kpaw

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Converts string to de.kpaw.md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
