using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class LearningOutcome
    {
        [Key]
        public int IdLearningOutcome { get; set; }


        [DataType(DataType.MultilineText)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Resultado de aprendizaje")]
        public string Description { get; set; }

        public int IdActivity { get; set; }
        public virtual Activity Activity { get; set; }

        public virtual ICollection<Competition> Competition { get; set; }



    }
}