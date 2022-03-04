package jp.wasabeef.transformers.coil

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.createBitmap
import coil.size.Size
import jp.wasabeef.transformers.core.Blur
import jp.wasabeef.transformers.core.bitmapConfig

/**
 * Copyright (C) 2020 Wasabeef
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

class BlurTransformation @JvmOverloads constructor(
  context: Context,
  radius: Int = 25,
  private val sampling: Int = 1,
  rs: Boolean = true
) : BaseTransformation(Blur(context, radius, sampling, rs)) {

  override suspend fun transform(input: Bitmap, size: Size): Bitmap {
    val scaledWidth: Int = input.width / sampling
    val scaledHeight: Int = input.height / sampling
    val output = createBitmap(scaledWidth, scaledHeight, bitmapConfig(input))
    return transformer.transform(input, output)
  }
}