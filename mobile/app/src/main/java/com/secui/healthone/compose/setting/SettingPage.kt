package com.secui.healthone.compose.setting

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.clickable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.secui.healthone.ui.setting.*
import com.secui.healthone.constant.PageRoutes

@Composable
fun SettingPage(navController: NavController) {
    val context = LocalContext.current
    val showLogoutDialog = remember { mutableStateOf(false) }
//    val showWithdrawDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        val arrow = ">"
        val settingsItems = listOf(
            "기본설정 및 목표 변경하기" to PageRoutes.DataCollectFirst.route,
            "알림 설정" to PageRoutes.AlarmSetting.route,
            "개인 데이터 다운로드" to PageRoutes.UserInformDown.route,
            "개인 데이터 삭제" to PageRoutes.UserInformDelete.route,
            "로그아웃" to "logout",
//            "회원탈퇴" to "withdraw"
        )

        settingsItems.forEach { (item, route) ->
            if (item == "로그아웃") {
                SettingsRow(item = item, textStyle = textStyle, arrow = arrow, onClick = { showLogoutDialog.value = true })
            }
//            else if (item == "회원탈퇴") {
//                SettingsRow(item = item, textStyle = textStyle, arrow = arrow, onClick = { showWithdrawDialog.value = true })
//            }
            else if (item == "알림 설정") {
                SettingsRow(item = item, textStyle = textStyle, arrow = arrow, onClick = { navController.navigate(route) })
            } else {
                SettingsRow(item = item, textStyle = textStyle, arrow = arrow, onClick = { navController.navigate(route) })
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (showLogoutDialog.value) {
            LogoutDialog(
                onConfirm = {
                    logout(context, navController)
                },
                onCancel = {
                    showLogoutDialog.value = false
                })
        }


//        if (showWithdrawDialog.value) {
//            WithdrawDialog(onConfirm = { /* 회원탈퇴 코드 */ }, onCancel = { showWithdrawDialog.value = false })
//        }
    }
}

@Composable
fun SettingsRow(item: String, textStyle: TextStyle, arrow: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item,
            style = textStyle
        )
        Text(
            text = arrow,
            style = textStyle
        )
    }
}

fun logout(context: Context, navController: NavController) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("secret_shared_prefs", Context.MODE_PRIVATE)
    sharedPreferences.edit().remove("access_token").apply()
    navController.navigate(PageRoutes.Login.route)
}