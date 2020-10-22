import org.gradle.api.Project

// Use from Groovy for now
fun platformOf(project: Project): String {
    if (project.name == "benchmarks") return "jvm"
    return when (project.name.substringAfterLast("-")) {
        "js" -> "js"
        "common", "native" -> throw IllegalStateException("${project.name} platform is not supported")
        else -> "jvm-multiplatform"
    }
}
