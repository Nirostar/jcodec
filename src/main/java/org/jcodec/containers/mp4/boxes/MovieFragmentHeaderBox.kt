package org.jcodec.containers.mp4.boxes

import java.nio.ByteBuffer

/**
 * This class is part of JCodec ( www.jcodec.org ) This software is distributed
 * under FreeBSD License
 *
 * Movie fragment header box
 *
 *
 * @author The JCodec project
 */
class MovieFragmentHeaderBox(atom: Header) : FullBox(atom) {
    var sequenceNumber = 0
    override fun parse(input: ByteBuffer) {
        super.parse(input)
        sequenceNumber = input.int
    }

    override fun doWrite(out: ByteBuffer) {
        super.doWrite(out)
        out.putInt(sequenceNumber)
    }

    override fun estimateSize(): Int {
        return 16
    }

    companion object {
        @JvmStatic
        fun fourcc(): String {
            return "mfhd"
        }

        fun createMovieFragmentHeaderBox(): MovieFragmentHeaderBox {
            return MovieFragmentHeaderBox(Header(fourcc()))
        }
    }
}