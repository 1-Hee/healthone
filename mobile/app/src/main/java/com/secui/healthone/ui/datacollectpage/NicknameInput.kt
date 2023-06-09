package com.secui.healthone.ui.datacollectpage

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.secui.healthone.constant.AppColors


@Composable
fun NicknameInput(nicknameState: String, onNicknameChange: (String) -> Unit) {
    val (textState, setTextState) = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "닉네임",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.width(40.dp))
        TextField(
            value = textState,
            onValueChange = { newText ->
                setTextState(newText)
                onNicknameChange(newText)
            },
            visualTransformation = VisualTransformation.None,
            maxLines = 1,
            textStyle = TextStyle(
                color = AppColors.black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = AppColors.green200,
                unfocusedIndicatorColor = AppColors.green200
            ),
            modifier = Modifier
                .width(240.dp)
                .height(48.dp)
                .clip(RoundedCornerShape(32.dp)),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
                autoCorrect = false,
                capitalization = KeyboardCapitalization.None
            ),
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }),
            interactionSource = interactionSource
        )
    }
}