package com.example.gavri.polls

import org.scalatest._

class PluralitySpec extends FunSpec with Matchers {
  describe("Plurality") {
    it("should return the candidate with the most number of votes"){
      val firstCandidate = Candidate("first candidate")
      val secondCandidate = Candidate("second candidate")
      val plurality = Plurality(List(firstCandidate, secondCandidate, firstCandidate))
      plurality.winners should equal (Set(firstCandidate))
    }

    it("should return the candidates with the most number of votes") {
      val firstCandidate = Candidate("first candidate")
      val secondCandidate = Candidate("second candidate")
      val thirdCandidate = Candidate("third candidate")
      val plurality = Plurality(List(firstCandidate, secondCandidate, firstCandidate, thirdCandidate, thirdCandidate))
      plurality.winners should equal (Set(firstCandidate, thirdCandidate))
    }

    it("should return an empty set if nobody voted") {
      Plurality(List()).winners should equal (Set())
    }
  }
}
