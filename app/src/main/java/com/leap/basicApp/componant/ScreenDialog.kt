package com.leap.basicApp.componant

import androidx.compose.material3.Surface
import android.view.Surface
import android.widget.CheckBox
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.Popup
import com.leap.basicApp.R
import com.leap.basicApp.ui.theme.Surface
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDialog(){
    // 1. Data class definition
    data class InvoiceField(
        val label: String,
        val value: String
    )

// 2. Data structured by sections matching the UI screenshot
    val invoiceSections = mapOf(
        "General Info" to listOf(
            InvoiceField(label = "Invoice No", value = "INV-0001"),
            InvoiceField(label = "Date", value = "17-03-2026"),
            InvoiceField(label = "Customer", value = "John Doe")
        ),
        "Item Info" to listOf(
            InvoiceField(label = "Item", value = "iPhone 15"),
            InvoiceField(label = "Quantity", value = "1"),
            InvoiceField(label = "Price", value = "$1200.00")
        ),
        "Payment" to listOf(
            InvoiceField(label = "Tax", value = "$120.00"),
            InvoiceField(label = "Total", value = "$1320.00")
        )
    )
    val invoicePairs = listOf(
        "Invoice Number" to "INV-2026-0821",
        "Date" to "August 21, 2026",
        "Total Due" to "$1,584.00"
    )
    var openDialog by remember { mutableStateOf(false) }
    var openFullScreenDialog by remember { mutableStateOf(true) }
    val invoice = """
        
            ========================================
                         INVOICE DETAILS            
            ========================================
            Invoice Number : INV-2026-0821
            Date           : August 21, 2026
            Due Date       : September 20, 2026
            ----------------------------------------
            CUSTOMER INFORMATION
            ----------------------------------------
            Client Name    : Acme Corporation
            Email          : billing@acme.com
            ----------------------------------------
            LINE ITEMS
            ----------------------------------------
            Item 1         : Web Development Work   $1,200.00
            Item 2         : Cloud Hosting (1 Yr)     $240.00
            ----------------------------------------
            PAYMENT SUMMARY
            ----------------------------------------
            Subtotal       : $1,440.00
            Tax (10%)      :   $144.00
            TOTAL DUE      : $1,584.00
            ========================================
       
    """.trimIndent()
    if(openDialog){
        AlertDialog(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_plus),
                    contentDescription = "Example Icon"
                )
            },
            title = {
                Text(text = "dialogTitle")
            },
            text = {
                Text(text = "This is my alert Dialog Contain")
            },
            onDismissRequest = {
//                openDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        println("Perform Action Base On Virtual Task")
                        openDialog = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
    if(openFullScreenDialog) {
        Dialog(
            onDismissRequest = {
                openDialog = true
            },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            ),
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background.copy(alpha = 0.8f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),

                    ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .height(56.dp),
                        verticalAlignment  = Alignment.CenterVertically,

                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "Invoice",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        IconButton(
                            onClick = {
                                openFullScreenDialog = false
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.surface
                            )
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.close),
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.background
                            )
                        }

                    }
                    /*
                    Dialog Content
                     */
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(16.dp)
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        invoiceSections.forEach {
                            (title, items)->
                            Box(
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .fillMaxWidth()
                                    .background(color = MaterialTheme.colorScheme.primary.copy(0.8f)),
                            ) {
                                Text(
                                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp ),
                                    text = title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.background.copy(0.7f)
                                )
                            }
                            items.forEach { (label,value)->
                                Row(
                                    Modifier.fillMaxWidth()
                                        .padding(horizontal = 8.dp)
                                        .padding(vertical = 16.dp)
                                ) {
                                    Text(
                                        modifier = Modifier.weight(1f),
                                        text = label
                                    )
                                    Text(
                                        modifier = Modifier.weight(1f),
                                        text = value
                                    )
                                }
                                HorizontalDivider()

                            }

                        }
                    }

                    /*
                    Dialog footer
                     */


                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {

                        },
                    ) {
                        Text("Confirm")
                    }
                }

            }
        }
    }

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {},

                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back ),
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.outline_notifications),
                            contentDescription = ""
                        )
                    }
                },
                title = {
                    Text(
                        text = "Dialog"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700)
                )
            )
        },
        bottomBar = {
            Row(
                Modifier.fillMaxWidth(),
            ) {
                Button(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {
                        openDialog = true
                    }
                ) {
                    Text("Alert Dialog")
                }

                Button(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {
                        openFullScreenDialog = true
                    }
                ) {
                    Text("Full Dialog")
                }
            }
        }

    ) {padding->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(16.dp),
              text = invoice,

          )

        }

    }
}

@Preview(showBackground = false)
@Composable
fun ScreenDialogPreview(){
    ScreenDialog()

}