package com.example.prak5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {

    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textPekerjaan by remember { mutableStateOf("") }


    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var pekerjaan by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val pekerjaanList = listOf("Mahasiswa", "Haram", "Halal")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    )  {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(height = 100.dp)
                .background(color = MaterialTheme.colorScheme.primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 120.dp, start = 10.dp, end = 10.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = "Nama",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 5.dp, start = 4.dp)
            )
            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(0.9f),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = { textNama = it }
            )
            Text(
                text = "Jenis Kelamin",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 5.dp, start = 4.dp)
            )
            Column(modifier = Modifier.padding(bottom = 15.dp)) {
                gender.forEach { item ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        )
                        Text(item)
                    }
                }
            }
            Text(
                text = "Status Pekerjaan",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 5.dp, start = 4.dp)
            )
            Column(modifier = Modifier.padding(bottom = 15.dp)) {
                pekerjaanList.forEach { item ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = textPekerjaan == item,
                                onClick = { textPekerjaan = item }
                            )
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textPekerjaan == item,
                            onClick = { textPekerjaan = item }
                        )
                        Text(item)
                    }
                }
            }
            Text(
                text = "Alamat",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 5.dp, start = 4.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth(0.9f),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                gender.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        )
                        Text(item)
                    }
                }
            }


            OutlinedTextField(
                value = textAlamat,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f),
                label = { Text(text = "Alamat Lengkap") },
                onValueChange = { textAlamat = it }
            )


            Divider(
                modifier = Modifier.fillMaxWidth(0.9f),
                thickness = dimensionResource(R.dimen.divider_tipis),
                color = Color.DarkGray
            )


            Button(
                modifier = Modifier.fillMaxWidth(0.9f),

                enabled = textNama.isNotEmpty() && textAlamat.isNotEmpty() && textJK.isNotEmpty(),
                onClick = {

                    nama = textNama
                    jenis = textJK
                    alamat = textAlamat
                }
            ) {
                Text(stringResource(R.string.submit))
            }


            Divider(
                modifier = Modifier.fillMaxWidth(0.9f),
                thickness = dimensionResource(R.dimen.divider_tipis),
                color = Color.DarkGray
            )


            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Black),
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(0.95f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround
                ) {

                    Text(text = "Nama   : $nama", color = Color.White)
                    Text(text = "Gender : $jenis", color = Color.White)
                    Text(text = "Alamat : $alamat", color = Color.White)
                }
            }
        }
    }

}