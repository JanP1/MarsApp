import { LocalDate } from "../../../core/model/local-date.model";
import { Author } from "./author.model";

export interface News {
  id: string,
  publishedAt: LocalDate, // Custom date type
  url: string,
  newsSite: string,
  summary: string,
  author: Author[],

}
