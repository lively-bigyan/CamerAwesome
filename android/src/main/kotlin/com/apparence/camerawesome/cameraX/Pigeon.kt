// Autogenerated from Pigeon (v4.2.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.apparence.camerawesome

import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

/** Generated class from Pigeon. */

/** Generated class from Pigeon that represents data sent in messages. */
data class PreviewSize(
  val width: Double,
  val height: Double
) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromMap(map: Map<String, Any?>): PreviewSize {
      val width = map["width"] as Double
      val height = map["height"] as Double

      return PreviewSize(width, height)
    }
  }
  fun toMap(): Map<String, Any?> {
    val map = mutableMapOf<String, Any?>()
    map["width"] = width
    map["height"] = height
    return map
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class PreviewData(
  val textureId: Double? = null,
  val size: PreviewSize? = null
) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromMap(map: Map<String, Any?>): PreviewData {
      val textureId = map["textureId"] as? Double
      val size: PreviewSize? = (map["size"] as? Map<String, Any?>)?.let {
        PreviewSize.fromMap(it)
      }

      return PreviewData(textureId, size)
    }
  }
  fun toMap(): Map<String, Any?> {
    val map = mutableMapOf<String, Any?>()
    textureId?.let { map["textureId"] = it }
    size?.let { map["size"] = it.toMap() }
    return map
  }
}

@Suppress("UNCHECKED_CAST")
private object CameraInterfaceCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      128.toByte() -> {
        return (readValue(buffer) as? Map<String, Any?>)?.let {
          PreviewData.fromMap(it)
        }
      }
      129.toByte() -> {
        return (readValue(buffer) as? Map<String, Any?>)?.let {
          PreviewSize.fromMap(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is PreviewData -> {
        stream.write(128)
        writeValue(stream, value.toMap())
      }
      is PreviewSize -> {
        stream.write(129)
        writeValue(stream, value.toMap())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface CameraInterface {
  fun setupCamera(callback: () -> Unit)
  fun checkPermissions(): List<String>
  fun requestPermissions(): List<String>
  fun getPreviewTextureId(cameraId: Long): PreviewData
  fun takePhoto(): String
  fun takeVideo(): String
  fun stopRecordingVideo()
  fun start(): Boolean
  fun stop(): Boolean
  fun setFlashMode(mode: String)
  fun handleAutoFocus()
  fun setZoom(zoom: Double)
  fun setSensor(sensor: String)
  fun setCorrection(brightness: Double)
  fun getMaxZoom(): Double
  fun focus()
  fun setCaptureMode(mode: String)
  fun setRecordingAudioMode(enableAudio: Boolean)
  fun availableSizes(): List<PreviewSize>
  fun refresh()
  fun getEffectivPreviewSize(): PreviewSize
  fun setPhotoSize(size: PreviewSize)

  companion object {
    /** The codec used by CameraInterface. */
val codec: MessageCodec<Any?> by lazy {
      CameraInterfaceCodec
    }
    /** Sets up an instance of `CameraInterface` to handle messages through the `binaryMessenger`. */
    @Suppress("UNCHECKED_CAST")
    fun setUp(binaryMessenger: BinaryMessenger, api: CameraInterface?) {
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setupCamera", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              api.setupCamera() {
                reply.reply(null)
              }
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
              reply.reply(wrapped)
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.checkPermissions", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              wrapped["result"] = api.checkPermissions()
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.requestPermissions", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              wrapped["result"] = api.requestPermissions()
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.getPreviewTextureId", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              val args = message as List<Any?>
              val cameraIdArg = args[0].let { if (it is Int) it.toLong() else it as Long }
              wrapped["result"] = api.getPreviewTextureId(cameraIdArg)
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.takePhoto", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              wrapped["result"] = api.takePhoto()
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.takeVideo", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              wrapped["result"] = api.takeVideo()
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.stopRecordingVideo", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              api.stopRecordingVideo()
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.start", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              wrapped["result"] = api.start()
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.stop", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              wrapped["result"] = api.stop()
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setFlashMode", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              val args = message as List<Any?>
              val modeArg = args[0] as String
              api.setFlashMode(modeArg)
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.handleAutoFocus", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              api.handleAutoFocus()
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setZoom", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              val args = message as List<Any?>
              val zoomArg = args[0] as Double
              api.setZoom(zoomArg)
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setSensor", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              val args = message as List<Any?>
              val sensorArg = args[0] as String
              api.setSensor(sensorArg)
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setCorrection", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              val args = message as List<Any?>
              val brightnessArg = args[0] as Double
              api.setCorrection(brightnessArg)
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.getMaxZoom", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              wrapped["result"] = api.getMaxZoom()
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.focus", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              api.focus()
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setCaptureMode", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              val args = message as List<Any?>
              val modeArg = args[0] as String
              api.setCaptureMode(modeArg)
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setRecordingAudioMode", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              val args = message as List<Any?>
              val enableAudioArg = args[0] as Boolean
              api.setRecordingAudioMode(enableAudioArg)
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.availableSizes", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              wrapped["result"] = api.availableSizes()
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.refresh", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              api.refresh()
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.getEffectivPreviewSize", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              wrapped["result"] = api.getEffectivPreviewSize()
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.CameraInterface.setPhotoSize", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val wrapped = hashMapOf<String, Any?>()
            try {
              val args = message as List<Any?>
              val sizeArg = args[0] as PreviewSize
              api.setPhotoSize(sizeArg)
              wrapped["result"] = null
            } catch (exception: Error) {
              wrapped["error"] = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}

private fun wrapResult(result: Any?): Map<String, Any?> {
  return hashMapOf("result" to result)
}

private fun wrapError(exception: Throwable): Map<String, Any> {
  return hashMapOf<String, Any>(
    "error" to hashMapOf<String, Any>(
      "code" to exception.javaClass.simpleName,
      "message" to exception.toString(),
      "details" to "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  )
}
