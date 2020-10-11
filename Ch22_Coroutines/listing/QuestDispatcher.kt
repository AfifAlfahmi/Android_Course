package com.example.SAFCSP

import kotlinx.coroutines.*
import sun.awt.Mutex

private const val ADVENTURER_COUNT = 4000
private const val QUEST_REWARD_SIZE = 100
private const val TREASURE_THREAD_CONTEXT_NAME = "TreasureContext"
@ObsoleteCoroutinesApi
private var treasureContext: ExecutorCoroutineDispatcher= newSingleThreadContext(TREASURE_THREAD_CONTEXT_NAME)

private val treasureMutex = Mutex()
private var treasureCount = 0

fun main() {
    runBlocking {
        withContext(treasureContext) {
            dispatchAdventurers(ADVENTURER_COUNT) {
                bounty ->treasureMutex.lock()
                try {
                    treasureCount += bounty
                }
                finally {
                    treasureMutex.unlock()}
            }
        }
        println("Total haul: \$$treasureCount")
    }
}
private suspend fun dispatchAdventurers(
        adventurerCount: Int,
        quest: suspend (Int) -> Unit) {
    coroutineScope {
        repeat(adventurerCount) {
            launch{
                quest(QUEST_REWARD_SIZE)
            }
        }
    }
}