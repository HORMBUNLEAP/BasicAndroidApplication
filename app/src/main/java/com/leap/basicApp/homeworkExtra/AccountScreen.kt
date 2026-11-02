package com.leap.basicApp.homeworkExtra

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leap.basicApp.R

// Data model for individual bank accounts
data class BankAccount(
    val type: String, // "USD" or "KHR"
    val titleEn: String,
    val titleKh: String,
    val accountNumber: String,
    val balance: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(){
    val scrollState = rememberScrollState()

    // State to track the selected filter option ("All", "USD $", "KHR ៛")
    var selectedFilter by remember { mutableStateOf("All") }
    val filters = listOf("All", "USD $", "KHR ៛")

    // Sample list of accounts matching the picture
    val allAccounts = listOf(
        BankAccount("USD", "Savings", "សន្សំ", "USD •••• 4821", "$12,480.50"),
        BankAccount("USD", "Current", "ចរន្ត", "USD •••• 7305", "$3,215.00"),
        BankAccount("KHR", "Savings", "សន្សំ", "KHR •••• 1190", "៛25,600,000"),
        BankAccount("KHR", "Current", "ចរន្ត", "KHR •••• 6642", "៛4,180,000")
    )

    // Filter accounts based on selection
    val filteredAccounts = when (selectedFilter) {
        "USD $" -> allAccounts.filter { it.type == "USD" }
        "KHR ៛" -> allAccounts.filter { it.type == "KHR" }
        else -> allAccounts
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                },
                title = { Text(text = "Account") },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.outline_notifications),
                            contentDescription = "Notification"
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.more01),
                            contentDescription = "More"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700)
                )
            )
        }
    ){ padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .background(color = colorResource(R.color.smoke_white)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Header Section: Title & Add Button
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Accounts", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                        Text(text = "គណនី", fontSize = 18.sp, fontWeight = FontWeight.Normal)
                    }
                    IconButton(
                        modifier = Modifier.background(shape = CircleShape, color = colorResource(R.color.gray)),
                        onClick = {}
                    ) {
                        Icon(painter = painterResource(R.drawable.icon_add), contentDescription = "Add")
                    }
                }
            }

            // Total Balance Card Section
            Box(
                modifier = Modifier
                    .height(240.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(
                        color = colorResource(R.color.black_zin),
                        shape = RoundedCornerShape(20.dp)
                    ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Total Balance", fontSize = 14.sp, color = Color.Gray)
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(".", color = Color.Gray)
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(modifier = Modifier.weight(1f), text = "សមតុល្យសរុប", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text(text = "$", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "23,140.50", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        // USD Box
                        Column(
                            modifier = Modifier
                                .height(65.dp)
                                .weight(1f)
                                .background(color = colorResource(R.color.gray), shape = RoundedCornerShape(20.dp))
                        ) {
                            Column(modifier = Modifier.padding(start = 15.dp, top = 10.dp, end = 15.dp).fillMaxSize()) {
                                Text(text = "USD · ដុល្លារ", color = Color(0xFF9EAEC3), fontSize = 12.sp, fontWeight = FontWeight.Medium)
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(text = "$15,695.50", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            }
                        }

                        Spacer(modifier = Modifier.width(15.dp))

                        // KHR Box
                        Column(
                            modifier = Modifier
                                .height(65.dp)
                                .weight(1f)
                                .background(color = colorResource(R.color.gray), shape = RoundedCornerShape(20.dp))
                        ) {
                            Column(modifier = Modifier.padding(horizontal = 15.dp).fillMaxSize()) {
                                Text(modifier = Modifier.padding(top = 10.dp), text = "KHR · រៀល", color = Color(0xFF9EAEC3), fontSize = 12.sp, fontWeight = FontWeight.Medium)
                                Text(text = "៛29,780,000", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(text = "Converted at $1 = ៛4,000 (Sample Rate)", color = colorResource(R.color.red), fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }

            // Filter Chips Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    filters.forEach { filter ->
                        val isSelected = selectedFilter == filter
                        val backgroundColor = if (isSelected) Color(0xFF111D2D) else Color.Transparent
                        val textColor = if (isSelected) Color.White else Color.DarkGray
                        val borderColor = if (isSelected) Color.Transparent else Color.LightGray

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50.dp))
                                .background(backgroundColor)
                                .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(50.dp))
                                .clickable { selectedFilter = filter }
                                .padding(horizontal = 24.dp, vertical = 10.dp)
                        ) {
                            Text(text = filter, color = textColor, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }

            // ----------------- Dynamic Account Lists Section -----------------
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Show USD section if "All" or "USD $" is selected
                if (selectedFilter == "All" || selectedFilter == "USD $") {
                    val usdList = filteredAccounts.filter { it.type == "USD" }
                    if (usdList.isNotEmpty()) {
                        AccountCategorySection(
                            categoryTitle = "US DOLLAR · ដុល្លារអាមេរិក",
                            accountCount = "${usdList.size} accounts",
                            accounts = usdList
                        )
                    }
                }

                // Show KHR section if "All" or "KHR ៛" is selected
                if (selectedFilter == "All" || selectedFilter == "KHR ៛") {
                    val khrList = filteredAccounts.filter { it.type == "KHR" }
                    if (khrList.isNotEmpty()) {
                        AccountCategorySection(
                            categoryTitle = "KHMER RIEL · រៀលកម្ពុជា",
                            accountCount = "${khrList.size} accounts",
                            accounts = khrList
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }

    }
}

@Composable
fun AccountCategorySection(
    categoryTitle: String,
    accountCount: String,
    accounts: List<BankAccount>
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        // Section Header Header
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = categoryTitle, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
            Text(text = accountCount, fontSize = 13.sp, color = Color.Gray)
        }

        // Account Cards
        accounts.forEach { account ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .border(1.dp, Color(0xFFE5E7EB), RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // Icon Circle
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .background(Color(0xFFEBF3FF), shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (account.type == "USD") "$" else "៛",
                                color = Color(0xFF0066FF),
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }

                        // Titles
                        Column {
                            Text(
                                text = "${account.titleEn} · ${account.titleKh}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = account.accountNumber,
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }

                    // Balance & Available
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = account.balance,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Available",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 1200)
@Composable
fun AccountScreenPreview() {
    AccountScreen()
}