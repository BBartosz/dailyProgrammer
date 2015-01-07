class HangPicture {
  def hangBuildStatus: List[String] = {
    List(
    """
    |------------------
    |  /
    | /
    |/
    |
    |
    |
    |
    |
    |
    |
    |
    |
    |
     _______
  """,
    """
      |------------------
      |  /            |
      | /             |
      |/              |
      |
      |
      |
      |
      |
      |
      |
      |
      |
      |
       _______
    """,
    """
      |------------------
      |  /            |
      | /             |
      |/              |
      |               O
      |
      |
      |
      |
      |
      |
      |
      |
      |
       _______
    """,
    """
      |------------------
      |  /            |
      | /             |
      |/              |
      |               O
      |               |
      |               |
      |
      |
      |
      |
      |
      |
      |
       _______
    """,
    """
      |------------------
      |  /            |
      | /             |
      |/              |
      |               O
      |              \|/
      |               |
      |
      |
      |
      |
      |
      |
      |
       _______
    """,
    """
      |------------------
      |  /            |
      | /             |
      |/              |
      |               O
      |              \|/
      |               |
      |              / \
      |
      |
      |
      |
      |
      |
       _______
    """
    )
  }
}