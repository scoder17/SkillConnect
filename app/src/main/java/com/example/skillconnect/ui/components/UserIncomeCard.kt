package com.example.connectly.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserIncomeCard(
    modifier: Modifier = Modifier,
    user: String,
    display: String,
    dispMonth: Boolean,
    incomeLastMonth: Double,
    incomeIncrease: Double
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
//                .fillMaxSize()
                .fillMaxWidth(0.60f)
                .padding(top = 16.dp, bottom = 16.dp, start = 20.dp, end = 20.dp),

            ) {

//            Row(
//                modifier = modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
                Text(
                    text = display,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
//                Spacer(modifier = modifier.width(100.dp))
                Text(
                    text = "Last Month",
                    color = Color.Gray,
                    style = MaterialTheme.typography.labelMedium
                )
//            }


            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "$ $incomeLastMonth",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                buildAnnotatedString {
                    if (dispMonth) {

                        if (incomeIncrease < 0) {
                            withStyle(style = SpanStyle(color = Color.Red)) {
                                append("-$incomeIncrease")
                            }
                        }
                        else {
                            withStyle(style = SpanStyle(color = Color.Green)) {
                                append("$incomeIncrease")
                            }
                        }

                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        ) {
                            append(" than last month ")
                        }
                    }
                    else {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        ) {
                            append("")
                        }
                    }


                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserIncomeCardPreview() {
    UserIncomeCard(
        user = "John Doe",
        display = "Expense",
        incomeLastMonth = 1000.0,
        dispMonth = false,
        incomeIncrease = 50.0
    )
}