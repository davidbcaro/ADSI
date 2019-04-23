using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class User
    {
        [Key]
        public int UserID { get; set; }

        [Required(ErrorMessage = "Este campo es obligatorio")]
        [Display(Name = "Número de documento")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("Project_CodeProject_Index", IsUnique = true)]
        public string documentNumber { get; set; }

        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Required(ErrorMessage = "Este campo es obligatorio")]
        [Display(Name = "Primer nombre")]
        public string FirstName { get; set; }

        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Display(Name = "Segundo nombre")]
        public string SecondName { get; set; }

        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Required(ErrorMessage = "Este campo es obligatorio")]
        [Display(Name = "Primer apellido")]
        public string FirstLastName { get; set; }

        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Required(ErrorMessage = "Este campo es obligatorio")]
        [Display(Name = "Segundo apellido")]
        public string SecondLastName { get; set; }


        [DataType(DataType.ImageUrl)]
        public string Photo { get; set; }
        [NotMapped]
        public HttpPostedFileBase PhotoFile { get; set; }



        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Correo")]
        [DataType(DataType.EmailAddress)]
        [RegularExpression("\\w+([-+.']\\w+)*@(gmail.com|misena.edu.co|sena.edu.co)$", ErrorMessage = "error solo se admite un correo gmail, misena o sena ")]
        public string Email { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Estado")]
        public bool State { get; set; }

        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Nombre de usuario")]
        public string UserName { get; set; }
        [NotMapped]
        [Display(Name = "Nombre del instructor")]
        public string FullName { get { return string.Format("{0}  {1} ", FirstName, FirstLastName); } }

        public int IdSpecialty { get; set; }
        public int IdTypeDocument { get; set; }
        public int IdLinkage { get; set; }
        public virtual Linkage Linkage { get; set; }
        public virtual TypeDocument TypeDocument { get; set; }
        public virtual Specialty Specialty { get; set; }

        public virtual ICollection<Shedule> Shedule { get; set; }

    }

  
}