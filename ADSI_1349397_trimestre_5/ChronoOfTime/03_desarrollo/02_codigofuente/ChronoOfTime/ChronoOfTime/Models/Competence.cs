using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Competence
    {
        [Key]
        [Column(Order = 7)]
        public  int IDCompetence { get; set; }
        [Display(Name ="Compentence")]
        [Required(ErrorMessage = "El campo Competence es obligatorio")]
        public string codeCompetence { get; set; }

        [Display(Name = "Description")]
        public string description { get; set; }


        //foreign

        [Display(Name = "Program")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public int IDProgram { get; set; }
        [ForeignKey("IDProgram")]
        public Program Program { get; set; }

        
        

    }
}