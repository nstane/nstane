package features

class PropertyGetterSetter(val fname: String, val lname: String) {
    var fullName: String get() = "${fname} ${lname}"
    set(name: String) {
        this.fullName = name;
    }
}