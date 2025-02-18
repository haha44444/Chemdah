package ink.ptms.chemdah.core

import ink.ptms.chemdah.core.quest.selector.InferArea
import ink.ptms.chemdah.core.quest.selector.InferArea.Companion.toInferArea
import ink.ptms.chemdah.core.quest.selector.InferBlock
import ink.ptms.chemdah.core.quest.selector.InferBlock.Companion.toInferBlock
import ink.ptms.chemdah.core.quest.selector.InferEntity
import ink.ptms.chemdah.core.quest.selector.InferEntity.Companion.toInferEntity
import ink.ptms.chemdah.core.quest.selector.InferItem
import ink.ptms.chemdah.core.quest.selector.InferItem.Companion.toInferItem
import taboolib.common.util.asList
import taboolib.common5.Coerce

/**
 * Chemdah
 * ink.ptms.chemdah.core.Data
 *
 * @author sky
 * @since 2021/3/2 12:00 上午
 */
open class Data {

    val data: Any
    var changed = false

    protected var lazyCache: Any? = null

    constructor(value: Int) {
        this.data = value
    }

    constructor(value: Float) {
        this.data = value
    }

    constructor(value: Double) {
        this.data = value
    }

    constructor(value: Long) {
        this.data = value
    }

    constructor(value: Short) {
        this.data = value
    }

    constructor(value: Byte) {
        this.data = value
    }

    constructor(value: Boolean) {
        this.data = value
    }

    protected constructor(value: Any) {
        this.data = value
    }

    fun toInt(): Int {
        return Coerce.toInteger(data)
    }

    fun toFloat(): Float {
        return Coerce.toFloat(data)
    }

    fun toDouble(): Double {
        return Coerce.toDouble(data)
    }

    fun toLong(): Long {
        return Coerce.toLong(data)
    }

    fun toShort(): Short {
        return Coerce.toShort(data)
    }

    fun toByte(): Byte {
        return Coerce.toByte(data)
    }

    fun toBoolean(): Boolean {
        return Coerce.toBoolean(data)
    }

    fun toVector(): InferArea {
        if (lazyCache !is InferArea) {
            lazyCache = toString().toInferArea(true)
        }
        return lazyCache as InferArea
    }

    fun toPosition(): InferArea {
        if (lazyCache !is InferArea) {
            lazyCache = toString().toInferArea()
        }
        return lazyCache as InferArea
    }

    fun toInferEntity(): InferEntity {
        if (lazyCache !is InferEntity) {
            lazyCache = data.asList().toInferEntity()
        }
        return lazyCache as InferEntity
    }

    fun toInferBlock(): InferBlock {
        if (lazyCache !is InferBlock) {
            lazyCache = data.asList().toInferBlock()
        }
        return lazyCache as InferBlock
    }

    fun toInferItem(): InferItem {
        if (lazyCache !is InferItem) {
            lazyCache = data.asList().toInferItem()
        }
        return lazyCache as InferItem
    }

    fun asList(): List<String> {
        return data.asList()
    }

    override fun toString(): String {
        if (data is List<*> && data.size == 1) {
            return data[0].toString()
        }
        return data.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Data) return false
        if (data != other.data) return false
        return true
    }

    override fun hashCode(): Int {
        return data.hashCode()
    }

    companion object {

        fun unsafeData(any: Any) = Data(any)
    }
}