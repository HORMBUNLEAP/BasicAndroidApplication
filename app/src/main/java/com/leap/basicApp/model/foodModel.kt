package com.leap.basicApp.model

import android.media.Image
import androidx.annotation.DrawableRes
import com.leap.basicApp.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

data class FoodModel(
    val id: Int,
    @DrawableRes val image: Int,
    val label : String,
    val rawDate: String,
    val description: String,
){
    val formattedDate: String
        get() = try {
            val inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH)
            val outputFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH)
            LocalDate.parse(rawDate, inputFormat).format(outputFormat)
        } catch (e: Exception) {
            rawDate // Fallback to raw string if parsing fails
        }
}
val foodList = listOf<FoodModel>(
    FoodModel(
        id = 1,
        image = R.drawable.image01,
        label = "Classroom 01",
        rawDate = "10-12-2026",
        description = "សួស្តីឆ្នាំថ្មី ប្រពៃណីជាតិខ្មែរ!"
    ),
    FoodModel(
        id = 2,
        image = R.drawable.image02,
        label = "Classroom 02",
        rawDate = "10-12-2026",
        description = "សូមជូនពរឱ្យឆ្នាំថ្មីនេះ នាំមកនូវសេចក្តីសុខ សុភមង្គល និងភាពរីកចម្រើន។"
    ),
    FoodModel(
        id = 3,
        image = R.drawable.image03,
        label = "Classroom 03",
        rawDate = "10-12-2026",
        description = "សូមឱ្យមានសុខភាពល្អ និងកម្លាំងមាំមួនជានិច្ច។"
    ),
    FoodModel(
        id = 4,
        image = R.drawable.image04,
        label = "Classroom 04",
        rawDate = "10-12-2026",
        description = "សូមឱ្យការងារ និងការសិក្សាទទួលបានជោគជ័យគ្រប់ពេល।"
    ),
    FoodModel(
        id = 5,
        image = R.drawable.image05,
        label = "Classroom 05",
        rawDate = "10-12-2026",
        description = "សូមឱ្យមានលាភសំណាង និងទ្រព្យសម្បត្តិកាន់តែច្រើន។"
    ),
    FoodModel(
        id = 6,
        image = R.drawable.image05,
        label = "Classroom 05",
        rawDate = "10-12-2026",
        description = "សូមឱ្យគ្រួសារមានសេចក្តីសុខ សាមគ្គីភាព និងសុភមង្គល។"
    ),
    FoodModel(
        id = 7,
        image = R.drawable.image05,
        label = "Classroom 05",
        rawDate = "10-12-2026",
        description = "សូមឱ្យរាល់ក្តីប្រាថ្នារបស់អ្នកបានសម្រេចដូចបំណង។"
    ),
    FoodModel(
        id = 8,
        image = R.drawable.image05,
        label = "Classroom 05",
        rawDate = "10-12-2026",
        description = "រីករាយឆ្នាំថ្មីប្រពៃណីខ្មែរ! សូមជូនពរឱ្យអ្នក និងក្រុមគ្រួសារ សុខសប្បាយ និងមានសុភមង្គលជារៀងរហូត!"
    ),
)
data class dateModel(
    val rawDate: String
){
    val formattedDate: String
        get() = try {
            val inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH)
            val outputFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH)
            LocalDate.parse(rawDate, inputFormat).format(outputFormat)
        } catch (e: Exception) {
            rawDate // Fallback to raw string if parsing fails
        }
}
val datelist = listOf(
    dateModel(rawDate = "10-12-2026"), // Formats to: 10-Dec-2026
    dateModel(rawDate = "15-01-2026"), // Formats to: 15-Jan-2026
    dateModel(rawDate = "01-02-2026"), // Formats to: 01-Feb-2026
    dateModel(rawDate = "22-03-2026"), // Formats to: 22-Mar-2026
    dateModel(rawDate = "05-04-2026"), // Formats to: 05-Apr-2026
    dateModel(rawDate = "18-05-2026"), // Formats to: 18-May-2026
    dateModel(rawDate = "30-06-2026"), // Formats to: 30-Jun-2026
    dateModel(rawDate = "12-07-2026"), // Formats to: 12-Jul-2026
    dateModel(rawDate = "25-08-2026"), // Formats to: 25-Aug-2026
    dateModel(rawDate = "09-09-2026")  // Formats to: 09-Sep-2026
)
