package jp.wasabeef.transformers.coil.gpu

import android.content.Context
import android.graphics.PointF
import jp.co.cyberagent.android.gpuimage.filter.GPUImageZoomBlurFilter

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

/**
 * @param blurCenter A multiplier for the blur size, ranging from 0.0 on up, with a default of 1.0
 * @param blurSize  The normalized center of the blur. (0.5, 0.5) by default
 */
class ZoomBlurFilterTransformation @JvmOverloads constructor(
  context: Context,
  private val blurCenter: PointF = PointF(0.5f, 0.5f),
  private val blurSize: Float = 1.0f
) : GPUFilterTransformation(
  context,
  GPUImageZoomBlurFilter().apply {
    setBlurCenter(blurCenter)
    setBlurSize(blurSize)
  }
) {

  override val cacheKey: String get() = "$id(blurCenter=$blurCenter, blurSize=$blurSize)"
}