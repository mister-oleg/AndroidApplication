package com.example.electronicstudent

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.electronicstudent.ui.theme.ElectronicStudentTheme
import com.example.electronicstudent.viewModel.CodeViewModel
import com.example.electronicstudent.viewModel.StudentViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ElectronicStudentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Route.Enter.route){
                        composable(Route.Enter.route){
                            ScreenEnter(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                codeViewModel = CodeViewModel())
                        }
                        composable(Route.Main.route + "/{studentId}"){
                            stackEntry ->
                            val studentId = stackEntry.arguments?.getString("studentId")
                            val studentViewModel = StudentViewModel()
                            studentViewModel.getStudentData(studentId.toString())
                            ScreenMain(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                studentViewModel = studentViewModel)
                        }
                        composable(Route.ChangeAvatar.route + "/{studentId}"){
                            stackEntry ->
                            val studentId = stackEntry.arguments?.getString("studentId")
                            val studentViewModel = StudentViewModel()
                            studentViewModel.getStudentData(studentId.toString())
                            ScreenChangeAvatar(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController)
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun ScreenEnter(modifier: Modifier = Modifier, codeViewModel: CodeViewModel = CodeViewModel(), studentViewModel: StudentViewModel = StudentViewModel(), navController: NavController) {

    Box(modifier = Modifier, contentAlignment = Alignment.Center)
    {
    Image(
        painter = ColorPainter(colorResource(R.color.background)),
        contentDescription = "background"
    )
    Box(modifier = Modifier.padding(20.dp, 40.dp)) {
        Image(
        painter = ColorPainter(colorResource(R.color.background2)),
        contentDescription = "background",
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
    )
        Column(verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        )
        {
            Text(
                stringResource(R.string.text_welcome),
                Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(colorResource(R.color.textBackground)),
                fontSize = 5.em,
                textAlign = TextAlign.Center
            )
            OutlinedTextField(value = codeViewModel.codeText, {codeViewModel.setCode(it)},
                Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .size(150.dp, 70.dp),
                colors = TextFieldDefaults.colors(focusedContainerColor = colorResource(R.color.textBackground), unfocusedContainerColor = colorResource(R.color.textBackground)),
                textStyle = TextStyle(fontSize = 4.em, textAlign = TextAlign.Center)
            )
            /*Text(
                stringResource(R.string.text_field_enter),
                Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(colorResource(R.color.textBackground)),
                fontSize = 5.em,
                textAlign = TextAlign.Center
            )*/

            Button(onClick = {

                if (studentViewModel.getStudentData(codeViewModel.codeText)) {
                    navController.navigate(Route.Main.route + "/${codeViewModel.codeText}")
                }
                             },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button), contentColor = Color.Black))
            {
                Text(text = stringResource(R.string.text_enter),
                    fontSize = 5.em
                    )

            }
        }
        }
     }
}

@Composable
fun ScreenMain(modifier: Modifier = Modifier, studentViewModel: StudentViewModel = StudentViewModel(), navController: NavController)
{
    Log.i("main", studentViewModel.studentData.avatar.toString())
    Box(modifier = Modifier, contentAlignment = Alignment.Center)
    {
        Image(
            painter = ColorPainter(colorResource(R.color.background)),
            contentDescription = "background"
        )
        Box(modifier = Modifier.padding(20.dp, 20.dp)) {
            Image(
                painter = ColorPainter(colorResource(R.color.background2)),
                contentDescription = "background",
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
            )
            Column(verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
            )
            {
                Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = {navController.navigate(Route.Enter.route)},
                        modifier = Modifier.width(94.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button))) {
                        Text(text = stringResource(R.string.text_exit), color = Color.Black)
                    }
                    Button(onClick = {},
                        modifier = Modifier.width(80.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button)),) {
                        Text(text = stringResource(R.string.text_notification), color = Color.Black, fontSize = (3).em)
                    }
                }
                Image(bitmap = studentViewModel.studentData.avatar, contentDescription = "Avatar", modifier = Modifier.size(120.dp))
                Button(onClick = {navController.navigate(Route.ChangeAvatar.route + "/${studentViewModel.studentData?.code.toString()}")},
                    modifier = Modifier.width(120.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button)),) {
                    Text(text = stringResource(R.string.text_change), color = Color.Black, fontSize = (3.5).em, softWrap = false)

                }
                Image(bitmap = ImageBitmap.imageResource(R.drawable.qr_code), contentDescription = "QRCODE", modifier = Modifier.size(200.dp).background(Color.White))
                Text(
                    studentViewModel.studentData.name,
                    Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .background(colorResource(R.color.textBackground))
                        .size(220.dp,50.dp),
                    fontSize = 5.em,
                    textAlign = TextAlign.Center,
                    lineHeight = (2.3).em
                )
                Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        studentViewModel.studentData?.group.toString(),
                        Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .background(colorResource(R.color.textBackground))
                            .size(110.dp,50.dp),
                        fontSize = 5.em,
                        textAlign = TextAlign.Center,
                        lineHeight = (2.3).em
                    )
                    Text(
                        studentViewModel.studentData?.college.toString(),
                        Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .background(colorResource(R.color.textBackground))
                            .size(110.dp,50.dp),
                        fontSize = 5.em,
                        textAlign = TextAlign.Center,
                        lineHeight = (2.3).em
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenChangeAvatar(modifier: Modifier = Modifier, studentViewModel: StudentViewModel = StudentViewModel(), navController: NavController)
{
    Log.i("changeavatar", studentViewModel.studentData.avatar.toString())
    val context = LocalContext.current
    val singlePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {studentViewModel.setAvatar(context, it)})

    Box(modifier = Modifier, contentAlignment = Alignment.Center)
    {


        Image(
            painter = ColorPainter(colorResource(R.color.background)),
            contentDescription = "background"
        )
        Box(modifier = Modifier.padding(20.dp, 20.dp)) {
            Image(
                painter = ColorPainter(colorResource(R.color.background2)),
                contentDescription = "background",
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
            )
            Column(verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
            )
            {
                Box(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 10.dp)) {
                    Button(onClick = {navController.popBackStack()},
                        modifier = Modifier.width(94.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button))) {
                        Text(text = stringResource(R.string.text_back), color = Color.Black)
                    }
                }
                Image(bitmap = studentViewModel.studentData.avatar, contentDescription = "Avatar", modifier = Modifier.size(120.dp))
                Box(modifier = Modifier.size(250.dp))
                {
                    Image(painter = ColorPainter(colorResource(R.color.textBackground)), contentDescription = "Avatars", modifier = Modifier.fillMaxSize().clip(shape = RoundedCornerShape(25.dp)))

                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.avatar),
                        contentDescription = "Avatar",
                        modifier = Modifier.size(120.dp).align(Alignment.BottomEnd).padding(10.dp)
                    )
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.avatar),
                        contentDescription = "Avatar",
                        modifier = Modifier.size(120.dp).align(Alignment.BottomStart).padding(10.dp)
                    )
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.avatar),
                        contentDescription = "Avatar",
                        modifier = Modifier.size(120.dp).align(Alignment.TopEnd).padding(10.dp)
                    )
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.avatar),
                        contentDescription = "Avatar",
                        modifier = Modifier.size(120.dp).align(Alignment.TopStart).padding(10.dp)
                    )

                }
                Button(onClick = {singlePhotoPicker.launch(PickVisualMediaRequest(
                    ActivityResultContracts.PickVisualMedia.ImageOnly))},
                    modifier = Modifier.width(150.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button)),) {
                    Text(
                        text = stringResource(R.string.text_load_from_phone),
                        color = Color.Black, fontSize = (3.5).em)
                }
                Button(onClick = {navController.popBackStack()},
                    modifier = Modifier.width(150.dp).padding(bottom = 10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button)),) {
                    Text(
                        text = stringResource(R.string.text_confirm),
                        color = Color.Black, fontSize = (3.5).em)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenEnterPreview() {
    ElectronicStudentTheme {
        //ScreenEnter(Modifier.fillMaxSize())
        //ScreenMain(Modifier.fillMaxSize())
        ScreenChangeAvatar(Modifier.fillMaxSize(), navController = rememberNavController())
    }
}

sealed class Route(val route: String){
    object Enter: Route("Enter")
    object Main: Route("Main")
    object ChangeAvatar: Route("ChangeAvatar")
}