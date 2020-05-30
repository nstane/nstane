package features

class ConstLateInit {

    private lateinit var propertyGetterSetter : PropertyGetterSetter

    fun setUp() {
        this.propertyGetterSetter = PropertyGetterSetter("", "")
    }

    companion object {
        const val NAME = "Companion Object"
    }
}