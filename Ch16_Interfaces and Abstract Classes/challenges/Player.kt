
class Player(  var  _name: String,
                 override var healthPoints: Int = 100,
                 var isBlessed: Boolean = false,
                 private var isImmortal: Boolean) : Fightable {
    override val diceCount =3
    override val diceSides=6

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed) {damageRoll * 2
        }
        else { damageRoll

        }
        opponent.healthPoints -= damageDealt
        return damageDealt    }

}