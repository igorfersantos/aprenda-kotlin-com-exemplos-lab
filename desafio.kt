// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { 
    BASICO, 
    INTERMEDIARIO, 
    AVANCADO;
}

data class Usuario(val nome: String, val nomeSocial: String?, val idade: Int) {
    override fun toString(): String = if (nomeSocial.isNullOrBlank()) nome else nomeSocial
}

data class ConteudoEducacional(var nome: String, var duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
       	for (usuario in usuarios) {
            inscritos.add(usuario)
            println("Usuario $usuario adicionado a formação de nível ${nivel.toString().lowercase()} \"$nome\"")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Python Básico", 60)
    val conteudo2 = ConteudoEducacional("Automating the boring stuff with Python", 120)
    val conteudo3 = ConteudoEducacional("Introdução a OOP com Python", 60)
    val conteudosPythonTarefasDiarias = listOf(conteudo1, conteudo2, conteudo3)
    val formacaoPythonTarefasDiarias = Formacao("Python para tarefas diárias", Nivel.BASICO, conteudosPythonTarefasDiarias)
    println(formacaoPythonTarefasDiarias)
    
    val conteudo4 = ConteudoEducacional("OOP Intermediário")
    val conteudo5 = ConteudoEducacional("Trabalhando com arquivos em Python")
    val conteudo6 = ConteudoEducacional("Introdução a APIs")
    val formacaoPythonIntermediario = Formacao("Python intermediário", Nivel.INTERMEDIARIO, listOf(conteudo4, conteudo5, conteudo6))
   	println(formacaoPythonIntermediario)
    
    val igor = Usuario("Igor Fernandes", null, 24)
    val maria = Usuario("Mariana Silva", "Mari", 20)
    
    formacaoPythonTarefasDiarias.matricular(igor)
    formacaoPythonIntermediario.matricular(igor)
    formacaoPythonIntermediario.matricular(maria)
}
