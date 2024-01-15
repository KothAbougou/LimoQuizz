package com.example.limoquizz.game

import kotlin.random.Random

data class Board(
    val player: Player
) {
    private var questionBank: ArrayList<Question> = arrayListOf(
        Question("Quelle est la capitale de l'Allemagne?","Berlin","Paris","Londres","Madrid","Berlin"),
        Question("Quel élément chimique a le symbole 'O'?","Oxygène","Or","Azote","Argon","Oxygène"),
        Question("Quelle est la plus grande planète du système solaire?","Vénus","Jupiter","Saturne","Mars","Jupiter"),
        Question("Quel est le langage de programmation principalement utilisé pour le développement Android?","Java","Kotlin","C++","Swift","Kotlin"),
        Question("Qui a écrit 'Roméo et Juliette'?","Charles Dickens","William Shakespeare","Jane Austen","Leo Tolstoï","William Shakespeare"),
        Question("Quelle est la capitale du Japon?","Séoul","Pékin","Tokyo","Bangkok","Tokyo"),
        Question("Combien de côtés a un triangle?","3","4","5","6","3"),
        Question("Quel est le plus grand océan du monde?","Océan Atlantique","Océan Pacifique","Océan Indien","Océan Arctique","Océan Pacifique"),
        Question("Qui a découvert la gravité en observant une pomme tomber d'un arbre?","Isaac Newton","Albert Einstein","Galilée","Marie Curie","Isaac Newton"),
        Question("Quelle est la capitale de l'Italie?","Rome","Madrid","Paris","Berlin","Rome"),
        Question("Quelle est la couleur du ciel par temps clair?","Rouge","Vert","Bleu","Jaune","Bleu"),
        Question("Quel est le symbole chimique de l'or?","Ag","Au","Fe","Hg","Au"),
        Question("Quelle est la plus grande île du monde?","Groenland","Australie","Islande","Borneo","Groenland"),
        Question("Quel est le plus grand désert du monde?","Désert du Sahara","Désert d'Atacama","Désert de Gobi","Désert de Kalahari","Désert du Sahara"),
        Question("Combien de lettres contient le mot 'hippopotame'?","8","10","12","14","12"),
        Question("Quelle est la capitale du Canada?","Ottawa","Toronto","Vancouver","Montréal","Ottawa"), Question("Quel est le plus grand océan du monde?","Océan Atlantique","Océan Pacifique","Océan Indien","Océan Arctique","Océan Pacifique"), Question("Quelle est la planète la plus proche du soleil?","Vénus","Mercure","Terre","Mars","Mercure"), Question("Quelle est la plus grande chaîne de montagnes du monde?","Himalaya","Andes","Rocheuses","Alpes","Himalaya"), Question("Qui a écrit 'Hamlet'?","Charles Dickens","William Shakespeare","Jane Austen","Leo Tolstoï","William Shakespeare"), Question("Quel est le plus grand mammifère terrestre?","Éléphant","Lion","Girafe","Rhinocéros","Éléphant"), Question("Quelle est la capitale de l'Inde?","Delhi","Mumbai","Calcutta","Bangalore","Delhi"), Question("Combien de minutes y a-t-il dans une heure?","30","45","60","90","60"), Question("Quelle est la planète la plus grande du système solaire?","Vénus","Jupiter","Saturne","Mars","Jupiter"), Question("Quel est le symbole chimique de l'argent?","Ag","Au","Fe","Hg","Ag"), Question("Quelle est la capitale de l'Espagne?","Barcelone","Madrid","Séville","Valence","Madrid"), Question("Quel est le plus grand lac d'eau douce du monde?","Lac Supérieur","Lac Baïkal","Lac Michigan","Lac Victoria","Lac Supérieur"), Question("Qui a écrit 'Orgueil et Préjugés'?","Charles Dickens","Jane Austen","Charlotte Brontë","Emily Brontë","Jane Austen"), Question("Combien de côtés a un carré?","3","4","5","6","4"), Question("Quel est le plus grand océan du monde?","Océan Atlantique","Océan Pacifique","Océan Indien","Océan Arctique","Océan Pacifique"),
        Question("Quelle est la capitale du Brésil?","Rio de Janeiro","Brasilia","Sao Paulo","Belo Horizonte","Brasilia"),
        Question("Quelle est la couleur du sang d'une araignée?","Rouge","Vert","Bleu","Jaune","Bleu"),
        Question("Quel est le plus grand organisme vivant sur Terre?","Éléphant","Baleine bleue","Séquoia géant","Champignon Armillaire","Champignon Armillaire"),
        Question("Combien de continents y a-t-il sur Terre?","5","6","7","8","7"),
        Question("Quelle est la capitale de l'Australie?","Melbourne","Sydney","Canberra","Brisbane","Canberra"),
        Question("Quelle est la planète la plus proche du soleil?","Vénus","Mercure","Terre","Mars","Mercure"),
        Question("Quelle est la plus haute montagne du monde?","Mont Everest","K2","Lhotse","Kangchenjunga","Mont Everest"),
        Question("Qui a peint 'Les Tournesols'?","Vincent van Gogh","Claude Monet","Pablo Picasso","Leonardo da Vinci","Vincent van Gogh"),
        Question("Combien de jours y a-t-il dans une année bissextile?","365","366","367","364","366"),
        Question("Quelle est la capitale de la Russie?","Saint-Pétersbourg","Moscou","Kazan","Samara","Moscou"),
        Question("Quel est le plus grand désert du monde?","Désert du Sahara","Désert d'Atacama","Désert de Gobi","Désert de Kalahari","Désert du Sahara"),
        Question("Quelle est la plus grande planète du système solaire?","Vénus","Jupiter","Saturne","Mars","Jupiter"),
        Question("Combien de côtés a un triangle?","3","4","5","6","3"),
        Question("Quelle est la couleur du ciel par temps clair?","Rouge","Vert","Bleu","Jaune","Bleu"),
        Question("Quel est le symbole chimique de l'or?","Ag","Au","Fe","Hg","Au"),
        Question("Quelle est la plus grande île du monde?","Groenland","Australie","Islande","Borneo","Groenland"),
        Question("Quel est le plus grand désert du monde?","Désert du Sahara","Désert d'Atacama","Désert de Gobi","Désert de Kalahari","Désert du Sahara"),
        Question("Combien de lettres contient le mot 'hippopotame'?","8","10","12","14","12"),
        Question("Quelle est la capitale du Canada?","Ottawa","Toronto","Vancouver","Montréal","Ottawa"),
        Question("Quel élément chimique a le symbole 'O'?","Oxygène","Or","Azote","Argon","Oxygène"),
        Question("Quelle est la plus grande planète du système solaire?","Vénus","Jupiter","Saturne","Mars","Jupiter"),
        Question("Quelle est la couleur du ciel par temps clair?","Rouge","Vert","Bleu","Jaune","Bleu"),
        Question("Quel est le symbole chimique de l'or?","Ag","Au","Fe","Hg","Au"),
        Question("Quelle est la plus grande île du monde?","Groenland","Australie","Islande","Borneo","Groenland"),
        Question("Qui a découvert la gravité en observant une pomme tomber d'un arbre?","Isaac Newton","Albert Einstein","Galilée","Marie Curie","Isaac Newton"),
        Question("Quelle est la capitale de l'Allemagne?","Berlin","Paris","Londres","Madrid","Berlin"),
        Question("Quel élément chimique a le symbole 'O'?","Oxygène","Or","Azote","Argon","Oxygène"),
        Question("Quelle est la plus grande planète du système solaire?","Vénus","Jupiter","Saturne","Mars","Jupiter"),
        Question("Qui a écrit 'Roméo et Juliette'?","Charles Dickens","William Shakespeare","Jane Austen","Leo Tolstoï","William Shakespeare"),
        Question("Quelle est la capitale du Japon?","Séoul","Pékin","Tokyo","Bangkok","Tokyo"),
        Question("Combien de côtés a un triangle?","3","4","5","6","3"),
        Question("Quel est le plus grand océan du monde?","Océan Atlantique","Océan Pacifique","Océan Indien","Océan Arctique","Océan Pacifique"),
        Question("Qui a découvert la gravité en observant une pomme tomber d'un arbre?","Isaac Newton","Albert Einstein","Galilée","Marie Curie","Isaac Newton"),
        Question("Quelle est la capitale de la France?","Berlin","Paris","Londres","Madrid","Paris"),
        Question("Quel élément chimique a le symbole 'O'?","Oxygène","Or","Azote","Argon","Oxygène"),
        Question("Quelle est la plus grande planète du système solaire?","Vénus","Jupiter","Saturne","Mars","Jupiter"),
        Question("Qui a écrit 'Hamlet'?","Charles Dickens","William Shakespeare","Jane Austen","Leo Tolstoï","William Shakespeare"),
        Question("Quelle est la capitale du Japon?","Séoul","Pékin","Tokyo","Bangkok","Tokyo"),
        Question("Quelle est la langue officielle du Japon?","Chinois","Coréen","Japonais","Vietnamien","Japonais"),
        Question("Quel est le symbole chimique de l'oxygène?","O","Oy","Ox","Oxy","O"),
        Question("Quel est le plus grand océan du monde?","Océan Atlantique","Océan Arctique","Océan Indien","Océan Pacifique","Océan Pacifique"),
        Question("Quel est le nombre de côtés d'un pentagone?","3","4","5","6","5"),
        Question("Quelle est la date de la fête nationale des États-Unis?","1er janvier","4 juillet","14 février","25 décembre","4 juillet"),
        Question("Combien de continents y a-t-il sur la planète Terre?","4","5","6","7","7"),
        Question("Quelle est la couleur du cheval blanc de Napoléon?","Blanc","Noir","Rouge","Vert","Blanc"),
        Question("Quel est le plus petit nombre premier?","1","2","3","4","2"),
        Question("Qui a écrit 'Roméo et Juliette'?","Charles Dickens","William Shakespeare","Jane Austen","Leo Tolstoï","William Shakespeare"),
        Question("Quel est le principal composant de l'air que nous respirons?","Azote","Oxygène","Dioxyde de carbone","Argon","Oxygène"),
        Question("Quelle est la première lettre de l'alphabet?","A","B","C","D","A"),
        Question("Quel est le plus grand désert du monde?","Le Sahara","L'Antarctique","Le Gobi","Le Kalahari","L'Antarctique"),
        Question("Quel est le symbole chimique de l'or?","Or","Au","Ag","Fe","Au"),
        Question("Qui a découvert la gravité en observant une pomme tomber?","Isaac Newton","Galilée","Einstein","Marie Curie","Isaac Newton"),
        Question("Quelle est la vitesse de la lumière?","300 000 km/s","150 000 km/s","500 000 km/s","1 000 000 km/s","300 000 km/s"),
        Question("Quel est le plus grand fleuve du monde?","Nil","Amazone","Mississippi","Yangtsé","Amazone"),
        Question("Combien de jours compte une année bissextile?","365","366","367","364","366"),
        Question("Quelle est la plus haute montagne du monde?","Mont Everest","Mont Kilimandjaro","Mont McKinley","Mont Fuji","Mont Everest"),
        Question("Quel est le plus grand animal terrestre?","Éléphant","Girafe","Rhinocéros","Hippopotame","Éléphant"),
        Question("Qui a peint 'La Nuit étoilée'?","Vincent van Gogh","Pablo Picasso","Claude Monet","Leonardo da Vinci","Vincent van Gogh"),
        Question("Quel est le nom du satellite naturel de la Terre?","Lune","Mars","Vénus","Jupiter","Lune"),
        Question("Quelle est la capitale de l'Allemagne?","Berlin","Paris","Londres","Madrid","Berlin"),
        Question("Quelle est la plus grande île du monde?","Groenland","Australie","Bornéo","Sumatra","Groenland"),
        Question("Quelle est la planète la plus proche du Soleil?","Mercure","Vénus","Terre","Mars","Mercure"),
        Question("Quel est le plus grand lac du monde en termes de superficie?","Mer Caspienne","Lac Supérieur","Lac Victoria","Lac Baïkal","Mer Caspienne"),
        Question("Qui a écrit 'Les Misérables'?","Victor Hugo","Fiodor Dostoïevski","Charles Dickens","Jane Austen","Victor Hugo"),
        Question("Quel est le nombre atomique de l'oxygène?","7","8","9","10","8"),
        Question("Quelle est la monnaie du Japon?","Yen","Won","Dollar","Euro","Yen"),
        Question("Quel est le plus grand oiseau du monde?","Autruche","Émeu","Aigle royal","Condor des Andes","Autruche"),
        Question("Quel est le plus long fleuve d'Afrique?","Nil","Congo","Niger","Zambèze","Nil"),
        Question("Qui a écrit 'Orgueil et Préjugés'?","Jane Austen","Charlotte Brontë","Emily Brontë","Charles Dickens","Jane Austen"),
        Question("Quel est le symbole chimique du carbone?","C","Ca","Co","Cu","C"),
        Question("Quelle est la première planète du système solaire?","Mercure","Vénus","Terre","Mars","Mercure"),
        Question("Quelle est la capitale du Canada?","Ottawa","Toronto","Montréal","Vancouver","Ottawa"),
        Question("Quel est le plus grand reptile du monde?","Crocodile marin","Varan de Komodo","Python réticulé","Tortue luth","Crocodile marin"),
        Question("Quelle est la couleur du drapeau français?","Bleu, blanc, rouge","Rouge, blanc, vert","Noir, rouge, jaune","Vert, blanc, rouge","Bleu, blanc, rouge"),
        Question("Combien de faces a un cube?","4","5","6","7","6"),
        Question("Quelle est la capitale de l'Australie?","Sydney","Melbourne","Canberra","Brisbane","Canberra"),
        Question("Quel est le plus grand insecte du monde?","Scarabée rhinocéros","Méganeura","Goliathus goliatus","Fourmi bulldog","Scarabée rhinocéros"),
        Question("Quel est le plus grand canyon du monde?","Grand Canyon","Canyon de Colca","Canyon de Chelly","Canyon de Waimea","Grand Canyon"),
        Question("Quel est le plus petit État du monde?","Monaco","Saint-Marin","Cité du Vatican","Nauru","Cité du Vatican"),
        Question("Qui a écrit 'Hamlet'?","William Shakespeare","Charles Dickens","Jane Austen","Leo Tolstoï","William Shakespeare"),
        Question("Quel est le plus grand océan du monde?","Océan Atlantique","Océan Arctique","Océan Indien","Océan Pacifique","Océan Pacifique"),
        Question("Quelle est la durée d'une partie de football (soccer)?","45 minutes","60 minutes","90 minutes","120 minutes","90 minutes"),
        Question("Quelle est la plus grande île du monde?","Groenland","Australie","Bornéo","Sumatra","Groenland"),
        Question("Quel est le plus grand désert du monde?","Le Sahara","L'Antarctique","Le Gobi","Le Kalahari","L'Antarctique"),
        Question("Quelle est la plus haute montagne du monde?","Mont Everest","Mont Kilimandjaro","Mont McKinley","Mont Fuji","Mont Everest"),
        Question("Quelle est la principale langue parlée au Brésil?","Espagnol","Portugais","Anglais","Français","Portugais"),
        Question("Quel est le plus grand poisson du monde?","Requin baleine","Requin tigre","Mégalodon","Raie manta","Requin baleine"),
        Question("Quelle est la plus grande planète du système solaire?","Jupiter","Saturne","Neptune","Uranus","Jupiter"),
        Question("Qui a écrit 'Crime et Châtiment'?","Fiodor Dostoïevski","Victor Hugo","Leo Tolstoï","Charles Dickens","Fiodor Dostoïevski"),
        Question("Quel est le pays le plus peuplé du monde?","Chine","Inde","États-Unis","Brésil","Chine"),
        Question("Quel est le plus grand mammifère terrestre?","Éléphant","Girafe","Hippopotame","Rhinocéros","Éléphant"),
        Question("Quel est le plus grand lac d'Afrique?","Lac Victoria","Lac Tanganyika","Lac Malawi","Lac Turkana","Lac Victoria"),
        Question("Quelle est la première lettre du mot 'xylophone'?","X","Y","Z","W","X"),
        Question("Quelle est la monnaie du Royaume-Uni?","Dollar","Euro","Livres sterling","Franc suisse","Livres sterling"),
        Question("Quel est le symbole chimique du sodium?","S","Sa","So","Na","Na"),
        Question("Quelle est la planète la plus éloignée du Soleil?","Pluton","Neptune","Uranus","Saturne","Neptune"),
        Question("Quelle est la date de la fête nationale de la Russie?","1er janvier","23 février","9 mai","12 juin","12 juin"),
        Question("Quel est le plus grand insecte volant du monde?","Lucane cerf-volant","Mégaloptère","Phasme feuille","Papillon Atlas","Papillon Atlas"),
        Question("Quel est le plus grand prédateur terrestre?","Lion","Tigre","Ours polaire","Crocodile","Ours polaire"),
        Question("Quel est le plus grand désert chaud du monde?","Le Sahara","L'Antarctique","Le Gobi","Le Kalahari","Le Sahara"),
        Question("Quel est le plus grand océan du monde?","Océan Atlantique","Océan Arctique","Océan Indien","Océan Pacifique","Océan Pacifique"),
        Question("Qui a écrit 'Les Trois Mousquetaires'?","Victor Hugo","Alexandre Dumas","Gustave Flaubert","Émile Zola","Alexandre Dumas"),
        Question("Quel est le plus grand lac du monde en termes de volume?","Lac Baïkal","Lac Supérieur","Lac Victoria","Lac Tanganyika","Lac Baïkal")
    )

    private var selectedQuestions: ArrayList<Question> = ArrayList()
    private var userSelectedAns: String = ""
    var currentIndex: Int = 0
    var nbCorrectAns: Int = 0
    var statut: String = "play"

    fun nextQuestion() {
        if(this.issetNextQuestion()){
            this.updateScores()
            this.currentIndex++
            this.statut = "play"
        }
    }
    
    fun userSelectAns(ans: String){
        this.userSelectedAns = ans
    }

    fun isTheCorrectAns(ans: String?): Boolean{
        return this.getCurrentQuestion().answer == ans
    }

    fun issetNextQuestion(): Boolean {
        return this.currentIndex +1 < this.selectedQuestions.size
    }

    fun getCurrentQuestion(): Question {
        return this.selectedQuestions[this.currentIndex]
    }

    fun getAllSelectedQuestions(): ArrayList<Question> {
        return  this.selectedQuestions
    }

    fun generateQuestions(nbQuestion: Int) {

        val indexList = this.generateIndexList(nbQuestion)
        val questionsGenerated: ArrayList<Question> = ArrayList()

        for(index: Int in indexList) {
            questionsGenerated.add(this.questionBank[index])
        }

        this.selectedQuestions = questionsGenerated
    }

    private fun generateIndexList(nbQuestion: Int): ArrayList<Int> {
        val randomIndexList : ArrayList<Int> = ArrayList()

        while(randomIndexList.size != nbQuestion) {
            val randomIndex = Random.nextInt(0, this.questionBank.size)
            if(!randomIndexList.contains(randomIndex)) {
                randomIndexList.add(randomIndex)
            }
        }

        return randomIndexList
    }

    fun updateScores() {
        if(this.userSelectedAns == this.getCurrentQuestion().answer)  {
            this.nbCorrectAns++

            if(this.nbCorrectAns % 3 == 0){
                this.player.addCoins(30)
            }

            if(this.nbCorrectAns == this.getAllSelectedQuestions().size) {
                this.player.addCoins(200)
            }
        }
    }
}