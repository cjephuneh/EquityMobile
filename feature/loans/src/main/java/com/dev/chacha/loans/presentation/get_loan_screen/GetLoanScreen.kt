package com.dev.chacha.loans.presentation.get_loan_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.theme.primaryPink

@Composable
fun GetLoanScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ){
              Column(modifier = Modifier.fillMaxSize()
                  .padding(start = 20.dp, end = 20.dp)) {

                  Image(
                      painter = painterResource(id = R.drawable.ic_loan),
                      contentDescription =  null,
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(180.dp)

                  )

                  Spacer(modifier =Modifier.height(30.dp))
                  Text(text = "General purpose Loan", color = Color.White)
                  Text(text = stringResource(id = R.string.purpose1), maxLines = 2)
                  Spacer(modifier =Modifier.height(15.dp))
                  Text(text = stringResource(id = R.string.purpose2), maxLines = 2)
                  Spacer(modifier =Modifier.height(15.dp))
                  Text(text = stringResource(id = R.string.purpose3), maxLines = 1)
                  Spacer(modifier =Modifier.height(15.dp))
                  Text(text = stringResource(id = R.string.purpose4), maxLines = 1)


                  Column(modifier = Modifier
                      .fillMaxSize(),
                      verticalArrangement = Arrangement.Bottom
                  ) {

                      OutlinedButton(
                          onClick = {
                          },
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(start = 8.dp, end = 8.dp),
                          colors = ButtonDefaults.outlinedButtonColors(
                              contentColor = Color.White,
                              containerColor = Color.Transparent,
                          ),
                          border = BorderStroke(1.dp, Color.White),
                          shape = RoundedCornerShape(8)
                      ) {
                          Text(
                              modifier = Modifier
                                  .fillMaxWidth()
                                  .padding(8.dp),
                              textAlign = TextAlign.Center,
                              text = "Check loan limit",
                              fontSize = 16.sp
                          )
                      }
                      Spacer(modifier = Modifier.height(16.dp))
                      Button(
                          onClick = {
                          },
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(start = 8.dp, end = 8.dp),
                          shape = RoundedCornerShape(8),
                          colors = ButtonDefaults.buttonColors(
                              containerColor = primaryPink
                          ),

                          ) {
                          Text(
                              modifier = Modifier
                                  .fillMaxWidth()
                                  .padding(8.dp),
                              textAlign = TextAlign.Center,
                              text = "Apply now",
                              color = Color.Black,
                              fontSize = 16.sp
                          )
                      }
                      Spacer(modifier = Modifier.height(20.dp))

                  }


              }


            }

        }


    }

}