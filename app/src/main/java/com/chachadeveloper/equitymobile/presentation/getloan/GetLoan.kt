package com.chachadeveloper.equitymobile.presentation.getloan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.presentation.components.CustomToolbar
import com.chachadeveloper.equitymobile.presentation.components.StandardToolbar
import com.chachadeveloper.equitymobile.presentation.destinations.LoginDestination
import com.chachadeveloper.equitymobile.presentation.destinations.RegisterDestination
import com.chachadeveloper.equitymobile.ui.theme.primaryPink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun GetLoan(navigator: DestinationsNavigator) {
    Column(modifier = Modifier.fillMaxSize()) {

        CustomToolbar(
            navigator = navigator,
            showBackArrow = true,
            modifier = Modifier.fillMaxSize(),
            title = {
                Text(
                    text = "Get Loan",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.body1
                )
            }
        )
        Column {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ){
              Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {

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
                              navigator.navigate(LoginDestination)
                          },
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(start = 8.dp, end = 8.dp),
                          colors = ButtonDefaults.outlinedButtonColors(
                              contentColor = Color.White,
                              backgroundColor = Color.Transparent,
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
                              navigator.navigate(RegisterDestination)
                          },
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(start = 8.dp, end = 8.dp),
                          shape = RoundedCornerShape(8),
                          colors = ButtonDefaults.buttonColors(
                              backgroundColor = primaryPink
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