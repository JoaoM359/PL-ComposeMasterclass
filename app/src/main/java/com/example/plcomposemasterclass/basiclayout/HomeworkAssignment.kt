package com.example.plcomposemasterclass.basiclayout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plcomposemasterclass.ui.theme.PLComposeMasterclassTheme

@Composable
fun HomeworkAssignment(
    title: String,
    description: String,
    date: String,
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFE87457),
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .border(
                        width = 1.5.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
                    .padding(2.dp)
            )

            Row(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                )
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .rotate(90f)
                    )
                }
            }
        }
        Text(
            text = description,
            color = Color.White,
            modifier = Modifier
                .padding(start = 36.dp)
        )

        Text(
            text = date,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.End)
        )
    }
}

@Preview
@Composable
private fun HomeworkAssignmentShortDescriptionPreview() {
    PLComposeMasterclassTheme {
        HomeworkAssignment(
            title = "Project X",
            description = "This is a short description",
            date = "Mar 5, 10:00",
        )
    }
}

@Preview
@Composable
private fun HomeworkAssignmentLongDescriptionPreview() {
    PLComposeMasterclassTheme {
        HomeworkAssignment(
            title = "Project X with a very long title",
            description = "Bacon ipsum dolor amet pork chop flank landjaeger cupim chicken ham, tail kielbasa swine burgdoggen spare ribs meatball. Tongue burgdoggen shank meatloaf ham hock tenderloin turkey, buffalo spare ribs. Capicola tri-tip spare ribs, drumstick landjaeger meatloaf chicken pork chop ground round turducken beef ribs shankle ribeye. Hamburger burgdoggen shank, tri-tip jerky prosciutto rump brisket meatloaf buffalo beef ribs short ribs t-bone sausage.",
            date = "Mar 5, 10:00",
        )
    }
}
