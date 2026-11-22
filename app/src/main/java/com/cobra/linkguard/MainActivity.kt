
package com.cobra.linkguard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CobraApp()
        }
    }
}

private val Black = Color(0xFF090909)
private val Red = Color(0xFFE50914)
private val White = Color(0xFFFFFFFF)
private val Gray = Color(0xFF1C1C1C)

@Composable
fun CobraApp() {
    var selected by remember { mutableStateOf("فحص الروابط") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Black)
                .padding(20.dp)
        ) {
            Text(
                "COBRA",
                color = Red,
                fontSize = 32.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                "LINK GUARD",
                color = White,
                fontSize = 14.sp,
                letterSpacing = 4.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("فحص الروابط", "COBRA AI", "الإعدادات").forEach {
                    Button(
                        onClick = { selected = it },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selected == it) Red else Gray
                        )
                    ) {
                        Text(it, color = White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            when (selected) {
                "فحص الروابط" -> LinkScanner()
                "COBRA AI" -> AssistantScreen()
                else -> SettingsScreen()
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "SECURED BY COBRA",
                color = Red,
                fontSize = 11.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun LinkScanner() {
    var link by remember { mutableStateOf("") }

    Text("فحص الروابط", color = White, fontSize = 23.sp)
    Spacer(modifier = Modifier.height(15.dp))

    OutlinedTextField(
        value = link,
        onValueChange = { link = it },
        label = { Text("ضع الرابط هنا") },
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = White,
            unfocusedTextColor = White,
            focusedBorderColor = Red,
            unfocusedBorderColor = Gray,
            focusedLabelColor = Red
        )
    )

    Spacer(modifier = Modifier.height(15.dp))

    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Red)
    ) {
        Text("افحص الرابط", color = White)
    }

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        "سيتم إضافة محركات فحص الأمان في المرحلة التالية.",
        color = Color.LightGray,
        fontSize = 13.sp
    )
}

@Composable
fun AssistantScreen() {
    Text("COBRA AI", color = Red, fontSize = 24.sp)
    Spacer(modifier = Modifier.height(15.dp))
    Text(
        "مساعدك الذكي لفهم الروابط ومخاطر الإنترنت.",
        color = White,
        fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(15.dp))
    Text("سيتم ربط Gemini لاحقاً.", color = Color.LightGray)
}

@Composable
fun SettingsScreen() {
    Text("الإعدادات", color = White, fontSize = 24.sp)
    Spacer(modifier = Modifier.height(20.dp))
    Text("اسم التطبيق: COBRA Link Guard", color = White)
    Spacer(modifier = Modifier.height(12.dp))
    Text("الإصدار: 1.0", color = White)
    Spacer(modifier = Modifier.height(12.dp))
    Text("Telegram: https://t.me/C0braa_7777", color = Red)
}
