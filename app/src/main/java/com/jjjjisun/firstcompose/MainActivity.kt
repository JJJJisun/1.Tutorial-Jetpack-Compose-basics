package com.jjjjisun.firstcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jjjjisun.firstcompose.ui.theme.FirstComposeTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // 프로젝트이름
            FirstComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("안드입니다?!")
                }
            }
        }
    }
}

// 뷰 -> 매개변수를 받아서 텍스트를 생성
// Text 자체에 모디파이어나 스타일을 지정 가능
@Composable
fun Greeting(name: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("안드로이드 첫 컴포즈") },
                backgroundColor = Color(0xfff25287)
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text("클릭")
            }
        },
    )
    {
//        Text(text = "안녕하세요?! $name!")
        MyComposableView()
    }
}

@Composable
fun MyComposableView() {
    Log.d("tag", "MyComposableView: 호출")

    // 리니어 레이아웃 - 버티컬
    Column(
        Modifier
            .background(Color.Green)
            .verticalScroll(rememberScrollState())
    ) {
        for (i in 0..30) {
            MyRowItem()
        }
    }
}

@Composable
fun MyRowItem() {

    // 리니어 레이아웃 - 호리젠탈
    Row(
        Modifier
            .padding(10.dp)
            .background(Color(0xffeaffd0))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "안녕하세요!",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Yellow)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요!")
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요!")
    }
}

// 미리보기
// 하지만 setContent 뷰와는 별개
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstComposeTheme {
        Greeting("Android")
    }
}