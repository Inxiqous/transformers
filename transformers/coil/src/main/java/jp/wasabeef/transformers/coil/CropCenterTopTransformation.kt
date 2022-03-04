package jp.wasabeef.transformers.coil

import android.graphics.Bitmap
import android.graphics.Bitmap.createBitmap
import coil.size.Size
import jp.wasabeef.transformers.core.Crop
import jp.wasabeef.transformers.core.bitmapConfig
import jp.wasabeef.transformers.types.GravityHorizontal
import jp.wasabeef.transformers.types.GravityVertical

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

typealias CenterTopCropTransformation = CropCenterTopTransformation

class CropCenterTopTransformation : BaseTransformation(
  Crop(
    aspectRatio = 1f,
    gravityHorizontal = GravityHorizontal.CENTER,
    gravityVertical = GravityVertical.TOP
  )
) {

  override suspend fun transform(input: Bitmap, size: Size): Bitmap {
    val calcSize = (transformer as Crop).calculateSize(input)
    val output = createBitmap(calcSize.width, calcSize.height, bitmapConfig(input))
    return transformer.transform(input, output)
  }
}