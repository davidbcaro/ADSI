using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Modality
    {
        [Key]
        public int IdModality { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Modalidad")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("Modality_nameModality_Index", IsUnique = true)]
        public string nameModality { get; set; }

        public virtual ICollection<Shedule> Shedule { get; set; }
    }
}