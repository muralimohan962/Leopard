package com.leopord.graphics

import java.awt.*
import java.awt.font.FontRenderContext
import java.awt.font.GlyphVector
import java.awt.geom.AffineTransform
import java.awt.image.BufferedImage
import java.awt.image.BufferedImageOp
import java.awt.image.ImageObserver
import java.awt.image.RenderedImage
import java.awt.image.renderable.RenderableImage
import java.text.AttributedCharacterIterator

open class Graphics2DDelegate(val delegate: Graphics2D) : Graphics2D() {

    override fun addRenderingHints(hints: Map<*, *>) {
        delegate.addRenderingHints(hints)
    }

    override fun clearRect(x: Int, y: Int, width: Int, height: Int) {
        delegate.clearRect(x, y, width, height)
    }

    override fun clip(s: Shape) {
        delegate.clip(s)
    }

    override fun clipRect(x: Int, y: Int, width: Int, height: Int) {
        delegate.clipRect(x, y, width, height)
    }

    override fun copyArea(x: Int, y: Int, width: Int, height: Int, dx: Int, dy: Int) {
        delegate.copyArea(x, y, width, height, dx, dy)
    }

    override fun create(): Graphics {
        return Graphics2DDelegate(delegate.create() as Graphics2D)
    }

    override fun dispose() {
        delegate.dispose()
    }

    override fun draw(s: Shape) {
        delegate.draw(s)
    }

    override fun drawArc(x: Int, y: Int, width: Int, height: Int, startAngle: Int, arcAngle: Int) {
        delegate.drawArc(x, y, width, height, startAngle, arcAngle)
    }

    override fun drawGlyphVector(g: GlyphVector, x: Float, y: Float) {
        delegate.drawGlyphVector(g, x, y)
    }

    override fun drawImage(img: BufferedImage, op: BufferedImageOp, x: Int, y: Int) {
        delegate.drawImage(img, op, x, y)
    }

    override fun drawImage(img: Image,
                           dx1: Int,
                           dy1: Int,
                           dx2: Int,
                           dy2: Int,
                           sx1: Int,
                           sy1: Int,
                           sx2: Int,
                           sy2: Int,
                           bgcolor: Color,
                           observer: ImageObserver): Boolean {
        return delegate.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer)
    }

    override fun drawImage(img: Image,
                           dx1: Int,
                           dy1: Int,
                           dx2: Int,
                           dy2: Int,
                           sx1: Int,
                           sy1: Int,
                           sx2: Int,
                           sy2: Int,
                           observer: ImageObserver): Boolean {
        return delegate.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
    }

    override fun drawImage(img: Image, x: Int, y: Int, bgcolor: Color, observer: ImageObserver): Boolean {
        return delegate.drawImage(img, x, y, bgcolor, observer)
    }

    override fun drawImage(img: Image, x: Int, y: Int, observer: ImageObserver): Boolean {
        return delegate.drawImage(img, x, y, observer)
    }

    override fun drawImage(img: Image, x: Int, y: Int, width: Int, height: Int, bgcolor: Color, observer: ImageObserver): Boolean {
        return delegate.drawImage(img, x, y, width, height, bgcolor, observer)
    }

    override fun drawImage(img: Image, x: Int, y: Int, width: Int, height: Int, observer: ImageObserver): Boolean {
        return delegate.drawImage(img, x, y, width, height, observer)
    }

    override fun drawImage(img: Image, xform: AffineTransform, obs: ImageObserver): Boolean {
        return delegate.drawImage(img, xform, obs)
    }

    override fun drawLine(x1: Int, y1: Int, x2: Int, y2: Int) {
        delegate.drawLine(x1, y1, x2, y2)
    }

    override fun drawOval(x: Int, y: Int, width: Int, height: Int) {
        delegate.drawOval(x, y, width, height)
    }

    override fun drawPolygon(xPoints: IntArray, yPoints: IntArray, nPoints: Int) {
        delegate.drawPolygon(xPoints, yPoints, nPoints)
    }

    override fun drawPolyline(xPoints: IntArray, yPoints: IntArray, nPoints: Int) {
        delegate.drawPolyline(xPoints, yPoints, nPoints)
    }

    override fun drawRenderableImage(img: RenderableImage, xform: AffineTransform) {
        delegate.drawRenderableImage(img, xform)
    }

    override fun drawRenderedImage(img: RenderedImage, xform: AffineTransform) {
        delegate.drawRenderedImage(img, xform)
    }

    override fun drawRoundRect(x: Int, y: Int, width: Int, height: Int, arcWidth: Int, arcHeight: Int) {
        delegate.drawRoundRect(x, y, width, height, arcWidth, arcHeight)
    }

    override fun drawString(iterator: AttributedCharacterIterator, x: Float, y: Float) {
        delegate.drawString(iterator, x, y)
    }

    override fun drawString(iterator: AttributedCharacterIterator, x: Int, y: Int) {
        delegate.drawString(iterator, x, y)
    }

    override fun drawString(s: String, x: Float, y: Float) {
        delegate.drawString(s, x, y)
    }

    override fun drawString(str: String, x: Int, y: Int) {
        delegate.drawString(str, x, y)
    }

    override fun fill(s: Shape) {
        delegate.fill(s)
    }

    override fun fillArc(x: Int, y: Int, width: Int, height: Int, startAngle: Int, arcAngle: Int) {
        delegate.fillArc(x, y, width, height, startAngle, arcAngle)
    }

    override fun fillOval(x: Int, y: Int, width: Int, height: Int) {
        delegate.fillOval(x, y, width, height)
    }

    override fun fillPolygon(xPoints: IntArray, yPoints: IntArray, nPoints: Int) {
        delegate.fillPolygon(xPoints, yPoints, nPoints)
    }

    override fun fillRect(x: Int, y: Int, width: Int, height: Int) {
        delegate.fillRect(x, y, width, height)
    }

    override fun fillRoundRect(x: Int, y: Int, width: Int, height: Int, arcWidth: Int, arcHeight: Int) {
        delegate.fillRoundRect(x, y, width, height, arcWidth, arcHeight)
    }

    override fun getBackground(): Color {
        return delegate.background
    }

    override fun getClip(): Shape {
        return delegate.clip
    }

    override fun getClipBounds(): Rectangle {
        return delegate.clipBounds
    }

    override fun getColor(): Color {
        return delegate.color
    }

    override fun getComposite(): Composite {
        return delegate.composite
    }

    override fun getDeviceConfiguration(): GraphicsConfiguration {
        return delegate.deviceConfiguration
    }

    override fun getFont(): Font {
        return delegate.font
    }

    override fun getFontMetrics(f: Font): FontMetrics {
        return delegate.getFontMetrics(f)
    }

    override fun getFontRenderContext(): FontRenderContext {
        return delegate.fontRenderContext
    }

    override fun getPaint(): Paint {
        return delegate.paint
    }

    override fun getRenderingHint(hintKey: RenderingHints.Key): Any {
        return delegate.getRenderingHint(hintKey)
    }

    override fun getRenderingHints(): RenderingHints {
        return delegate.renderingHints
    }

    override fun getStroke(): Stroke {
        return delegate.stroke
    }

    override fun getTransform(): AffineTransform {
        return delegate.transform
    }

    override fun hit(rect: Rectangle, s: Shape, onStroke: Boolean): Boolean {
        return delegate.hit(rect, s, onStroke)
    }

    override fun rotate(theta: Double) {
        delegate.rotate(theta)
    }

    override fun rotate(theta: Double, x: Double, y: Double) {
        delegate.rotate(theta, x, y)
    }

    override fun scale(sx: Double, sy: Double) {
        delegate.scale(sx, sy)
    }

    override fun setBackground(color: Color) {
        delegate.background = color
    }

    override fun setClip(sh: Shape) {
        delegate.clip = sh
    }

    override fun setClip(x: Int, y: Int, w: Int, h: Int) {
        delegate.setClip(x, y, w, h)
    }

    override fun setColor(color: Color) {
        delegate.color = color
    }

    override fun setComposite(comp: Composite) {
        delegate.composite = comp
    }

    override fun setFont(font: Font) {
        delegate.font = font
    }

    override fun setPaint(paint: Paint) {
        delegate.paint = paint
    }

    override fun setPaintMode() {
        delegate.setPaintMode()
    }

    override fun setRenderingHint(hintKey: RenderingHints.Key, hintValue: Any) {
        delegate.setRenderingHint(hintKey, hintValue)
    }

    override fun setRenderingHints(hints: Map<*, *>) {
        delegate.setRenderingHints(hints)
    }

    /*
     * Sets the Stroke in the current graphics state.
     * @param s The Stroke object to be used to stroke a Path in
     * the rendering process.
     * @see BasicStroke
     */
    override fun setStroke(s: Stroke) {
        delegate.stroke = s
    }

    override fun setTransform(Tx: AffineTransform) {
        delegate.transform = Tx
    }

    override fun setXORMode(c: Color) {
        delegate.setXORMode(c)
    }

    override fun shear(shx: Double, shy: Double) {
        delegate.shear(shx, shy)
    }

    override fun transform(xform: AffineTransform) {
        delegate.transform(xform)
    }

    override fun translate(tx: Double, ty: Double) {
        delegate.translate(tx, ty)
    }

    override fun translate(x: Int, y: Int) {
        delegate.translate(x, y)
    }
}
