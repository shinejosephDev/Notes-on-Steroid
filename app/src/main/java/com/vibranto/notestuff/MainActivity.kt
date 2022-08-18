package com.vibranto.notestuff

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.Coil
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.size.Scale
import com.vibranto.notestuff.ui.add_edit_note.AddEditNoteScreen
import com.vibranto.notestuff.ui.notes.NotesScreen
import com.vibranto.notestuff.ui.notes.viewmodel.NotesViewModel
import com.vibranto.notestuff.ui.utils.Screen
import com.vibranto.notestuff.ui.utils.theme.NoteStuffTheme
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("shine","onCreate")
        setContent {
            NoteStuffTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.NotesScreen.route){
                    composable(route = Screen.NotesScreen.route){
                        NotesScreen(navController = navController)
                    }
                    composable(
                        route = Screen.AddEditNoteScreen.route +
                                "?noteId={noteId}&noteColor={noteColor}",
                        arguments = listOf(
                            navArgument(
                                name = "noteId"
                            ) {
                                type = NavType.IntType
                                defaultValue = -1
                            },
                            navArgument(
                                name = "noteColor"
                            ) {
                                type = NavType.IntType
                                defaultValue = -1
                            },
                        )
                    ){
                        val color = it.arguments?.getInt("noteColor") ?: -1
                        AddEditNoteScreen(
                            navController = navController,
                            noteColor = color
                        )
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("shine","onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("shine","onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d("shine","onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("shine","onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("shine","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("shine","onDestroy")
    }
}

@Composable
fun ChatScreen() {
    Row {
        UserPhoto("https://www.iwmbuzz.com/wp-content/uploads/2021/06/shah-rukh-khans-most-stylish-beard-moments-that-redefine-age-for-people-in-50s-see-pics-3.jpg")
        Column {
            Row {
                Text(
                    text = "Shine Joseph!",
                )
                Text(
                    text = "4.10 am",
                )
            }
            Surface() {
                Text(
                    text = "I am learning Jetpack Compose",
                )
            }
        }
    }
}

@Composable
fun UserPhoto(imageUrl: String) {
    val ringColor = remember {
        randomColor()
    }
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = Modifier
            .border(2.dp, ringColor, CircleShape)
            .padding(4.dp)
            .clip(CircleShape)
            .size(40.dp),
        contentScale = ContentScale.FillHeight
    )
}

fun randomColor(): Color = Color(
    red = Random.nextInt(0, 255),
    green = Random.nextInt(0, 255),
    blue = Random.nextInt(0, 255)
)


@Preview(
    showBackground = true,
    device = "id:Nexus One",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    NoteStuffTheme {
        ChatScreen()
    }
}