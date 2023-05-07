package com.secui.healthone.ui.challenge.challengepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.secui.healthone.R
import com.secui.healthone.ui.common.AppColors

@Composable
fun ChallengeContentItem(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .background(AppColors.white)
            .padding(8.dp)
            .clickable { }
    ) {
        Column(
            modifier = Modifier
                .width(204.dp)
                .wrapContentHeight()
                .shadow(1.dp, RectangleShape, ambientColor = AppColors.black),
        )
        {
            // 이미지
            Image(painter =
            rememberImagePainter(ChallengeContentItemText.contentImgUrl),
                contentDescription = "컨텐츠 이미지",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(136.dp),
                contentScale = ContentScale.Crop
            )
        }

    }
}

class ChallengeContentItemText {
    companion object {
        const val contentImgUrl = "https://i.ytimg.com/vi/gC_L9qAHVJ8/maxresdefault.jpg"
    }
}